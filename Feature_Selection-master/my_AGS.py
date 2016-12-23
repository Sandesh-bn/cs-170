import math
import random
import heapq
import copy
import normalize as my_norm
import nearest_neighbor as my_nn

def InitHeap(data, num_instances, num_features, current_set_of_features):
    my_queue = []
    for i in range(1, num_features + 1):
        if (i not in current_set_of_features):
            accuracy = my_nn.OneOutCrossValidation(data, num_instances, \
                current_set_of_features, i)
            feature_pair = (1 - accuracy, i)
            heapq.heappush(my_queue, feature_pair)
    return my_queue

def SampleHeap(data, num_instances, num_features, current_set_of_features, my_queue):
    top = heapq.heappop(my_queue)
    feature_to_add = top[1]
    accuracy = my_nn.OneOutCrossValidation(data, num_instances, \
        current_set_of_features, feature_to_add)
    return feature_to_add, accuracy

def AdaptiveGreedySearch(data, num_instances, num_features):
    """
    First we perform NN on all features, push them into our
    priority queue with priority: (1 - accuracy) such that
    the most accurate features are in the front.
    After going through all possible features we select
    the best feature to be added to our set.
    Now we begin to add to our set of features one at a time
    from our queue.
    However, it the next feature in our heap decreases our accuracy, we will try to
    salvage it by going through the next X features in our heap defined by 'depth.'
    The depth should depend on the number of features.
    If we do not find a suitable feature with our depth we remake our heap.
    Since the search will take longer the more we remake our heap, we will only
    allow it to be remade once.
    If it does improve our accuracy, we add it and continue.
    There will also be a maximum limit to the number of features we can have.
    The maximum number of features will be 5.
    """
    print("-" * 50)

    current_set_of_features = set()
    queue_features = InitHeap(data, num_instances, num_features, \
        current_set_of_features)
    top = heapq.heappop(queue_features)
    feature_to_add = top[1]
    best_so_far_accuracy = 1 - top[0]
    current_set_of_features.add(feature_to_add)

    recently_reordered = False
    num_reorder = 0
    reorder_limit = 1
    iteration = 1
    depth = 2

    print("-" * 50)
    print("Initialized set with feature %d with accuracy: %f."\
        % (feature_to_add, best_so_far_accuracy))

    while (len(queue_features) != 0 and len(current_set_of_features) < 5):
        print("On iteration %d of the search" % (iteration), "with set as",\
           current_set_of_features)
        improved_accuracy = False
        for i in range(1, depth+1):
            feature_to_add, accuracy = SampleHeap(data, num_instances, num_features,\
                current_set_of_features, queue_features)
            if (accuracy > best_so_far_accuracy):
                print("\t** On iteration %d level %d of the heap," %\
                    (iteration, i), "adding feature %d" % (feature_to_add),\
                    "gives us accuracy: %f **" % (accuracy))
                current_set_of_features.add(feature_to_add)
                best_so_far_accuracy = accuracy
                improved_accuracy = True
                print("-" * 50)
                break
        if (recently_reordered and not improved_accuracy):
                print("\t*** Could not find suitable feature, stopping here.")
                print("-" * 50)
                break
        if (not improved_accuracy and num_reorder < reorder_limit):
            print("-" * 50)
            print("\t*** Next features in heap does NOT improve accuracy,",\
                "reinitializing heap with new set.")
            print("-" * 50)
            queue_features = InitHeap(data, num_instances, num_features,\
                current_set_of_features)
            print("-" * 50)
            recently_reordered = True
            num_reorder += 1
        else:
            print("On iteration %d of the search, adding feature %d" %\
                (iteration, feature_to_add), "gives us accuracy: %f" %\
                (accuracy))
            print("-" * 50)
            current_set_of_features.add(feature_to_add)
            best_so_far_accuracy = accuracy
            # Only allow remaking heap once if commented
            # also remember to change reorder_limit
            # recently_reordered = False
        iteration += 1
    print("Best set of features to use: ", current_set_of_features, "with accuracy",\
        best_so_far_accuracy)
