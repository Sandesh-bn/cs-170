from pprint import pprint
import math
import random
import normalize as my_norm
import nearest_neighbor as my_nn
import my_AGS

# instances[i][0] is class name

def LoadData(file_name, num_instances):
    try:
        f = open(file_name, 'r')
    except:
        raise FileNotFoundError(file_name)
    instances = [[] for i in range(num_instances)]
    for i in range(num_instances):
        instances[i] = [float(j) for j in f.readline().split()]
    return instances

def ForwardSelection(data, num_instances, num_features):
    print("-" * 50)
    current_set_of_features = set()
    best_so_far_accuracy = 0
    print("-" * 50)
    for i in range(num_features):
        print("On level %d of the search tree" % (i+ 1),\
            "with our set as", current_set_of_features)
        feature_to_add = -1
        for j in range(1, num_features + 1):
            if (j not in current_set_of_features):
                accuracy = my_nn.OneOutCrossValidation(data, num_instances,\
                    current_set_of_features, j)
                if accuracy > best_so_far_accuracy:
                    best_so_far_accuracy = accuracy
                    feature_to_add = j
        if (feature_to_add > 0):
            current_set_of_features.add(feature_to_add)
            print("On level %d of the search tree," % ((i+1)),\
                "adding feature %d gives accuracy: %f" \
                % (feature_to_add, best_so_far_accuracy))
            print("-" * 50)
        else:
            print("*** NOTE: Accuracy decreasing, stopping here.")
            break
    print("-" * 50)
    print("Best set of features to use: ", current_set_of_features,\
        "with accuracy", best_so_far_accuracy)

def BackwardElimination(data, num_instances, num_features):
    """
    To remove feature X, pass in -X to OneOutCrossValidation
    """
    print("-" * 50)
    current_set_of_features = set(i+1 for i in range(0, num_features))
    best_so_far_accuracy = 0
    print("-" * 50)
    for i in range(num_features):
        print("On level %d of the search tree" % (i+1),\
            "with our set as", current_set_of_features)
        feature_to_remove = -1
        for j in range(1, num_features + 1):
            if (j in current_set_of_features):
                accuracy = my_nn.OneOutCrossValidation(data, num_instances,\
                    current_set_of_features, (-1 *j))
                if accuracy > best_so_far_accuracy:
                    best_so_far_accuracy = accuracy
                    feature_to_remove = j
        if (feature_to_remove > 0):
            current_set_of_features.remove(feature_to_remove)
            print("On level %d of the search tree," % (i+1),\
                "removing feature %d gives accuracy: %f" \
                % (feature_to_remove, best_so_far_accuracy))
            print("-" * 50)
        else:
            print("*** NOTE: Accuracy decreasing, stopping here.")
            break
    print("-" * 50)
    print("Best set of features to use:", current_set_of_features,\
        "with accuracy", best_so_far_accuracy)

def main():
    #file_name = input("Enter the name of the file to test: ")
    file_name = "cs_205_large5.txt"
    num_instances = int(input("Enter the number of instances to read: "))
    instances = LoadData(file_name, num_instances)

    alg = ""
    while (alg != "FS" and alg != "BE" and alg != "CS"):
        alg = raw_input("""Type in the algorithm you want to run:
                       FS - Forward Selection
                       BE - Backward Elimination
                       CS - Custom Search \r""")
    num_features = len(instances[0]) - 1
    print("\t*** Normalizing data... ***")
    normalized_instances = my_norm.NormalizeData(instances, num_instances,\
        num_features)
    print("There are %d features with %d instances." % (num_features, num_instances))
    if (alg == "FS"):
        ForwardSelection(normalized_instances, num_instances, num_features)
    elif (alg == "BE"):
        BackwardElimination(normalized_instances, num_instances, num_features)
    else:
        my_AGS.AdaptiveGreedySearch(normalized_instances, num_instances, num_features)

if __name__ == '__main__':
    main()
