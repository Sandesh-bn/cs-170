#!/usr/bin/python 
import math
from sets import Set
import random

data_set = []
classes = []
normalized_data = []

def get_size_data_set(data):
	size_of_data = 0
	size_of_data = len(data) * (len(data[0])-1)
	return size_of_data


def get_size_feature(data): 
	feature_size = 0
	feature_size = len(data); 
	return feature_size 


def store_values(file_name):
	data = []
	data = [float(number) for line in open(file_name, 'r') for number in line.split()]
	temp = []
	
	x = 0

	while x != len(data): 
		for y in range(0, len(data)):#11): 
			temp.append(data[x])
			x = x + 1
		data_set.append(temp)
		temp = []


def leave_one_out_cross_validation(data, current_set, feature_to_add):
	accuracy = 0.0 
	temp_distance = 0.0 
	cnt = 0.0 
	temp = 0

	#loop through all items in feature = 100
	for x in range(get_size_feature(data)):
		distance = 1000; 
		#loop through all items in feature = 100
		for y in range(get_size_feature(data)):
			temp_distance = 0
			if x == y: 
				continue
			#loop through num features 10
			for j in range(len(current_set)):

				#Take euclidean distance of points in feature
				temp_distance += (current_set[j] * pow((data[x][j+1] - data[y][j+1]), 2))
			temp_distance = math.sqrt(temp_distance)

			#set smallest distance to temp_distance and save position
			if temp_distance < distance:
				distance = temp_distance
				temp = y

		#compare classes, if same class add 1 to cnt  
		if data[x][0] == data[temp][0]:
			cnt = cnt + 1

		accuracy = cnt/get_size_feature(data)

	return cnt 



# Begin with empty set, add highest accuracy 
def forward_selection(data):

	current_set_of_features = [0 for i in range(1, len(data[0]))]
	temp_features = [0 for i in range(1, len(data[0]))]
	feature_to_add_at_this_level = 0
	best_accuracy = 0 
	accuracy = 0

	size = len(current_set_of_features)

	#go through each level of the tree
	for i in range (0, size): 
		print "On the", i+1, "th level of the search tree"
		feature_to_add_at_this_level = 0
		best_so_far_accuracy = 0

		#check current set of features and get nearest neighbors using cross validation
		for k in range (0, size): 
			if current_set_of_features[k] != 1:
				current_set_of_features[k] = 1
			else:
				continue

			accuracy = leave_one_out_cross_validation(data, current_set_of_features, k)
			current_set_of_features[k] = 0

			print "\tUsing feature(s) {", k + 1, "} accuracy is ", accuracy, "%"

			if accuracy > best_so_far_accuracy:
				best_so_far_accuracy = accuracy
				feature_to_add_at_this_level = k
		
		current_set_of_features[feature_to_add_at_this_level] = 1 

		if best_so_far_accuracy > best_accuracy:
			best_accuracy = best_so_far_accuracy
			for i in range(len(current_set_of_features)):
				temp_features[i] = current_set_of_features[i]
	
		print "\nFeature set {",  

		for i in range(len(current_set_of_features)):
			if current_set_of_features[i] == 1:
				print i,

		print "} was best, accuracy is", best_so_far_accuracy, "%"


	print "\nFinished search!! The best feature subset is {",  

	for i in range(len(temp_features)):
			if temp_features[i] == 1:
				print i,

	print "}, which has an accuracy of", best_accuracy, "%"



# Begin with empty set, add highest accuracy 
def backward_elimination(data):

	current_set_of_features = [1 for i in range(1, len(data[0]))]
	temp_features = [0 for i in range(1, len(data[0]))]
	feature_to_add_at_this_level = 0
	best_accuracy = 0 
	accuracy = 0

	size = len(current_set_of_features)

	for i in range (0, size): 
		print "On the", i+1, "th level of the search tree"
		feature_to_add_at_this_level = 0
		best_so_far_accuracy = 0

		for k in range (0, size): 
			if current_set_of_features[k] != 0:
				current_set_of_features[k] = 0
			else:
				continue

			accuracy = leave_one_out_cross_validation(data, current_set_of_features, k)
			current_set_of_features[k] = 1
			print "\tUsing feature(s) {", k + 1, "} accuracy is ", accuracy, "%"

			if accuracy > best_so_far_accuracy:
				best_so_far_accuracy = accuracy
				feature_to_add_at_this_level = k
		
		current_set_of_features[feature_to_add_at_this_level] = 0

		if best_so_far_accuracy > best_accuracy:
			best_accuracy = best_so_far_accuracy
			for i in range(len(current_set_of_features)):
				temp_features[i] = current_set_of_features[i]
	
		print "\nFeature set {",  

		for i in range(len(current_set_of_features)):
			if current_set_of_features[i] == 1:
				print i,

		print "} was best, accuracy is", best_so_far_accuracy, "%"


	print "\nFinished search!! The best feature subset is {",  

	for i in range(len(temp_features)):
			if temp_features[i] == 1:
				print i,

	print "}, which has an accuracy of", best_accuracy, "%"


def minimize_data(data):
	new_data = []

	new_size = len(data)/2

	for i in range(new_size):	
		cnt = random.randint(1, new_size)
		new_data.append(data[cnt])

	#print new_data
	return new_data


# Begin with empty set, add highest accuracy 
# Same as forward search but runs faster with a smaller data set 
def special_algorithm(data):

	current_set_of_features = [0 for i in range(1, len(data[0]))]
	temp_features = [0 for i in range(1, len(data[0]))]
	feature_to_add_at_this_level = 0
	best_accuracy = 0 
	accuracy = 0

	size = len(current_set_of_features)

	#go through each level of the tree
	for i in range (0, size): 
		print "On the", i+1, "th level of the search tree"
		feature_to_add_at_this_level = 0
		best_so_far_accuracy = 0

		#check current set of features and get nearest neighbors using cross validation
		for k in range (0, size): 
			if current_set_of_features[k] != 1:
				current_set_of_features[k] = 1
			else:
				continue

			accuracy = leave_one_out_cross_validation(data, current_set_of_features, k)
			current_set_of_features[k] = 0

			print "\tUsing feature(s) {", k + 1, "} accuracy is ", accuracy, "%"

			if accuracy > best_so_far_accuracy:
				best_so_far_accuracy = accuracy
				feature_to_add_at_this_level = k
		
		current_set_of_features[feature_to_add_at_this_level] = 1 

		if best_so_far_accuracy > best_accuracy:
			best_accuracy = best_so_far_accuracy
			for i in range(len(current_set_of_features)):
				temp_features[i] = current_set_of_features[i]
	
		print "\nFeature set {",  

		for i in range(len(current_set_of_features)):
			if current_set_of_features[i] == 1:
				print i,

		print "} was best, accuracy is", best_so_far_accuracy, "%"


	print "\nFinished search!! The best feature subset is {",  

	for i in range(len(temp_features)):
			if temp_features[i] == 1:
				print i,

	print "}, which has an accuracy of", best_accuracy, "%"



# Change each column for feature X, (X-mean(X))/std(X)
def normalize_data(data):
	sum_data = 0.0
	j = 0.0

	for i in range(1, len(data_set[0])):
		sum = 0.0

		for j in range(len(data)):
			sum_data += data[j][i]

		mean = sum_data/get_size_data_set(data)

		sum = 0.0

		for k in range(len(data)): 
			sum += math.pow((data[k][i]-mean), 2)

		standard_deviation = math.sqrt(sum / (get_size_data_set(data) - 1))

		for k in range(len(data)):
			data[k][i] = (data[k][i] - mean)/standard_deviation

	print "Normalized data!"


###################### MAIN ########################
print "Welcome to Brittany's Feature Selection Algorithm."

file = raw_input("Type in the name of the file to test: ")
# print "Type in the name of the file to test: "

# file = "cs_170_small50.txt"

store_values(file)

print "Normalizing data...."
normalize_data(data_set)

print "\nType the number of the algorithm you want to run"
print "1) Forward Selection"
print "2) Backward Elimination"
print "3) Brittany's Special Algorithm"

algorithm = raw_input("Algorithm: ")

if (algorithm == "1"):
	print "\nThis dataset has", len(data_set[0])-1, "(not including the class attribute), with", (len(data_set[0])-1)*len(data_set), "instances\n"
	print "Beginning Forward Selection search: \n"
	forward_selection(data_set) 

if (algorithm == "2"):
	print "\nThis dataset has", len(data_set[0])-1, "(not including the class attribute), with", (len(data_set[0])-1)*len(data_set), "instances\n"
	print "Beginning Backward Selection search: \n"
	backward_elimination(data_set)

if (algorithm == "3"):
	data_set = minimize_data(data_set)
	print "\nThis dataset has", len(data_set[0])-1, "(not including the class attribute), with", (len(data_set[0])-1)*len(data_set), "instances\n"
	print "Beginning Brittany's special algorithm search: \n"
	special_algorithm(data_set)







