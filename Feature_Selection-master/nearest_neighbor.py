import math

def NearestNeighbor(instances, num_instances, one_out, features):
    nearest_neighbor = -1
    nearest_neighbor_distance = float('inf')
    num_features = len(features)
    for i in range(0, num_instances):
        if (i == one_out):
            pass
        else:
            sum = 0
            for j in range(0, num_features):
                sum = sum + pow((instances[i][features[j]] - instances[one_out][features[j]]), 2)
            distance = math.sqrt(sum)
            if distance < nearest_neighbor_distance:
                nearest_neighbor_distance = distance
                nearest_neighbor = i
    return nearest_neighbor

def CheckClassification(instances, nearest_neighbor, one_out):
    if (instances[nearest_neighbor][0] != instances[one_out][0]):
        return False
    return True

def OneOutCrossValidation(instances, num_instances, current_features, my_feature):
    """
    Pass in positive to add, negative to remove, 0 for no feature
    """
    if my_feature > 0:
        list_features = list(current_features)
        list_features.append(my_feature)
    elif my_feature < 0:
        my_feature = my_feature * -1
        current_features.remove(my_feature)
        list_features = list(current_features)
        current_features.add(my_feature)
    elif my_feature == 0:
        list_features = list(current_features)

    num_correct = 0
    for i in range(0, num_instances):
        one_out = i
        nearest_neighbor = NearestNeighbor(instances, num_instances, one_out, list_features)
        correct_classification = CheckClassification(instances, nearest_neighbor, one_out)
        if (correct_classification):
            num_correct += 1
    accuracy = num_correct / num_instances
    print("Testing features: ", list_features, " with accuracy %f" % accuracy)
    return accuracy
