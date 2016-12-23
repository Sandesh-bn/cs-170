from operator import itemgetter
import math
import statistics
import time

"""
Calculates and returns the distance between features
"""
def calc_distance(data1, data2, features):
    sum = 0
    for i in xrange(len(data1[1])):
        if (i + 1) in features:
            sum += (data1[1][i] - data2[1][i])**2
    return math.sqrt(sum)

"""
Calculates and returns the accuracy of the features of the dataset
"""
def leave_one_out_cross_validation(data, current_set, feature_to_add=None):
    correct = 0
    distances = {}
    if feature_to_add is not None:
        current_set.append(feature_to_add)
    for i in xrange(len(data)):
        neighbour = None
        min_distance = 999999
        for k in xrange(len(data)):
            if i != k:
                if distances.has_key((i, k)):
                    dist = distances[(i, k)] 
                else:
                    dist = calc_distance(data[i], data[k], current_set)
                    distances[(i, k)] = dist
                    distances[(k, i)] = dist
                if min_distance > dist:
                    min_distance = dist
                    neighbour = data[k]
        
        if neighbour is not None and neighbour != data[i]:
            if neighbour[0] == data[i][0]:
                correct += 1
    precentage = float(float(correct)/float(len(data)))*100
    return precentage

"""
Normalized the data so it's easier to use.
"""
def normalize(data):
    normal_data = []
    for i in xrange(len(data)):
        row = data[i].strip().split()
        features = []
        for feature in row[1:]:
            features.append(float(feature))
        normal_data.append((row[0], features))
    return normal_data

"""
Forward selection algorithm
"""
def forward_selection(data): 
    current_set_of_features = []
    print "Beginning search"
    best_accuracy_all = (0, [])
    for i in xrange(len(data[0][1])):
        feature_to_add = -1
        best_accuracy = 0

        for k in xrange(len(data[0][1])):
            if (k+1) not in current_set_of_features:
                accuracy = leave_one_out_cross_validation(data, current_set_of_features[:], k+1)
                set_of_features = current_set_of_features[:]
                set_of_features.append(k+1)
                print "Using feature(s)", set_of_features, "accuracy is", accuracy, "%"
                if accuracy >= best_accuracy:
                    best_accuracy = accuracy
                    feature_to_add = k + 1

        current_set_of_features.append(feature_to_add)

        if best_accuracy_all[0] >= best_accuracy:
            print "(Warning, Accuracy has decreased! Continuing search in case of local maxima)"
        else:
            best_accuracy_all = (best_accuracy, current_set_of_features[:])
        
        print "Feature set", current_set_of_features, " was best, accuracy is ", best_accuracy, "\n"
    print "Feature set", best_accuracy_all[1], " was best, accuracy is ", best_accuracy_all[0], "%\n"
    return best_accuracy_all

"""
Backward Selection Algorithm
"""
def backward_elimination(data): 
    current_set_of_features = []
    for i in xrange(len(data[0][1])):
        current_set_of_features.append(i + 1)
    print "Beginning search"
    best_accuracy_all = (leave_one_out_cross_validation(data, current_set_of_features[:]), current_set_of_features[:])
    print "Using feature(s)", current_set_of_features, "accuracy is", best_accuracy_all[0], "%\n"
    for i in xrange(len(data[0][1])):
        feature_to_remove = -1
        best_accuracy = 0
        if len(current_set_of_features) >= 2:
            for k in xrange(len(data[0][1])):
                if (k+1) in current_set_of_features:
                    temp_features = current_set_of_features[:]
                    temp_features.remove(k + 1)
                    accuracy = leave_one_out_cross_validation(data, temp_features)
                    
                    print "Using feature(s)", temp_features, "accuracy is", accuracy, "%"
                    if accuracy > best_accuracy:
                        best_accuracy = accuracy
                        feature_to_remove = k + 1

            current_set_of_features.remove(feature_to_remove)

            if best_accuracy_all[0] > best_accuracy:
                print "(Warning, Accuracy has decreased! Continuing search in case of local maxima)"
            else:
                best_accuracy_all = (best_accuracy, current_set_of_features[:])
            
            print "Feature set", current_set_of_features, " was best, accuracy is ", best_accuracy, "\n"
    print "Feature set", best_accuracy_all[1], " was best, accuracy is ", best_accuracy_all[0], "%\n"
    return best_accuracy_all

"""
My own original algorthm for feature selection
"""
def sachins_algorithm(data):
    current_set_of_features = []
    print "Beginning search"
    best_accuracy = (0, [])
    features = []
    for i in xrange(len(data[0][1])):
        features.append((i+1, leave_one_out_cross_validation(data, [i+1])))
    for feature in reversed(sorted(features, key=itemgetter(1))):
        current_set_of_features.append(feature[0])
        accuracy = leave_one_out_cross_validation(data, current_set_of_features[:])
        print "Using feature(s)", current_set_of_features, "accuracy is", accuracy, "%"
        if accuracy > best_accuracy[0]:
            best_accuracy = (accuracy, current_set_of_features[:])
        else:
            print "(Warning, Accuracy has decreased! Continuing search in case of local maxima)\n"
        
    print "Feature set", best_accuracy[1], " was best, accuracy is ", best_accuracy[0], "%\n"
    return best_accuracy

"""
Normalize the data in file for more accuracy.
"""
def normalize_file(data):
    new_data = []
    for __ in xrange(len(data[0].strip().split())):
        new_data.append([])
    for row in data:
        split_row = row.strip().split()
        for index, val in enumerate(split_row):
            new_data[index].append(float(val))

    for index in xrange(1, len(new_data)):
        data = new_data[index]
        mean = statistics.mean(data)
        std = statistics.stdev(data)
        for i in xrange(len(data)):
            data[i] = float(data[i] - mean)/float(std)

    to_write = []
    for x in zip(*new_data):
        to_write.append(' '.join(map(str,x)))
    return to_write

if __name__ == "__main__":
    print "Welcome to Sachin's Incredible Feature Selection Algorithm."
    file_name = raw_input("Type in the name of the file to test: ")
    choice = input("Type the number of the algorithm you want to run.\n1) Forward Selection\n2) Backward Selection\n3) Sachin's Special Algorithm.\nChoice: ")
    print "\n"
    new_data = []
    orig_data = []
    with open(file_name, "r") as f:
        data = f.readlines()
        num_features = len(data[0].strip().split()) - 1
        print "This dataset has %d features (not including the class attribute), with %d instances\n" % (num_features, len(data))
        print "Please wait while I normalize the data..."
        orig_data = normalize(normalize_file(data))
    print "Done.\n"
    t1 = time.time()
    if choice == 1:
        forward_selection(orig_data)
        t2 = time.time()
    elif choice == 2:
        backward_elimination(orig_data)
        t2 = time.time()
    else:
        sachins_algorithm(orig_data)
        t2 = time.time()
    print "The algorithm took " + str((t2-t1) * 1000)  + " ms of time."