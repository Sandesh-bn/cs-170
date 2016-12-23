
import sys, math, time, statistics
import forward_selection as fw
import backward_elimination as bw
import custom_search as cs

def normalize(data_set):
    ''' Returns the normalized data 
        using the relation: "x = (x - mean(x))/std(x)"
    '''
    print "Normalizing dataset"
    result, index2 = [[] for i in range(len(data_set[0].strip().split()))], 1
    for row in data_set:
        elements, i = row.strip().split(), 0
        for element in elements:
           result[i].append(float(element))
           i = i + 1
    
    while index2 < len(result):
        var = result[index2]
        standard_deviation, mean = statistics.stdev(var), statistics.mean(var)
        for i in range(len(var)):
            var[i] = float(var[i] - mean)/float(standard_deviation)
        index2 = index2 + 1

    normalized_info = [' '.join(map(str, inner_list)) for inner_list in zip(*result)]
    data_set = normalized_info
    result, limit, i = [], len(data_set), 0
    while i < limit:
        row = data_set[i].strip().split()
        features = [float(feature) for feature in row[1:]]
        result.append((row[0], features))
        i = i + 1
    return result        



def main():
    file_name = raw_input("Please enter file name: ")
    print "\n1. Forward Selection"
    print "2. Backward Selection"
    print "3. Custom Search"
    user_choice = input("Enter your choice: ")
    file_info = open(file_name, "r")
    data = file_info.readlines() 
    start_time = time.time()
    if user_choice == 1:
        fw.forward_selection(normalized_data)
    elif user_choice == 2:
        bw.backward_elimination(normalized_data)
    elif user_choice == 3:
        cs.custom_search(normalized_data)
    end_time = time.time()
    
    print "Time taken: {0} milliseconds ".format((end_time - start_time) * 1000)

main()


'''
References:
K-fold-cross-validation: https://www.youtube.com/watch?v=nZAM5OXrktY
http://machinelearningmastery.com/evaluate-performance-machine-learning-algorithms-python-using-resampling/
http://scikit-learn.org/stable/modules/neighbors.html
https://www.google.com/search?q=%22forward+selection%22&ie=utf-8&oe=utf-8#q=%22forward+selection%22&start=100
http://luisangeloshome.weebly.com/uploads/1/6/2/5/16253368/analysis.pdf
http://stackoverflow.com/questions/15389768/standard-deviation-of-a-list
http://www.dr-chuck.com/csev-blog/2010/01/fun-python-syntax-operator-itemgetter-sorted-and-lambda-functions-oh-my/

'''