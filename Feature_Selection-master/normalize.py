import math

def CalcMean(instances, num_instances, num_features):
    mean = []
    for i in range(1, num_features + 1): # Add one to exclude the class data
        mean.append((sum(row[i] for row in instances)) / num_instances)
    return mean

def CalcStd(instances, num_instances, num_features, mean):
    std = []
    for i in range(1, num_features + 1):
        std.append(math.sqrt((sum(pow((row[i] - mean[i-1]), 2) for row in instances)) / num_instances))
    return std

def NormalizeData(instances, num_instances, num_features):
    """
    Normalizes instances
    note: normalized_instances and instances are the same
    """
    normalized_instances = list(instances)
    mean = CalcMean(instances, num_instances, num_features)
    std = CalcStd(instances, num_instances, num_features, mean)
    for i in range(0, num_instances):
        for j in range(1, num_features + 1):
            normalized_instances[i][j] = ((instances[i][j] - mean[j-1]) / std[j-1])
    return normalized_instances


