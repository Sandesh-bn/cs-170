#include <iostream>
#include <stdlib.h>
#include <algorithm>
#include <fstream>
#include <string>
#include <vector>
#include <math.h>

using namespace std;

class userData {
	private:
		vector < vector < long double > > Data;
		vector < vector < long double > > Neighbors;
	public:
		userData() {
			Data.resize(100);
			Neighbors.resize(100);
			for (size_t i = 0; i < 100; i++)
			{
				Data[i].resize(11);
				// Store [0] neighbor val and [1] distance
				Neighbors[i].resize(2, 100);
			}
		};
		void backwardElimination();
		void forwardSelection();
		void calcNeighbor( vector<int> numSets );
		void parseData(string filename);
		void normalize();
		double kFold();
		void print();
};

int main() {

	string filename;
	int choice;
	userData Tony;

	cout << "Welcome to Tony's Feature Selection Algorithm! \n";
	cout << "Type in the name of the file to test: ";
	cin >> filename; cout << endl;
	
	Tony.parseData(filename);
	Tony.normalize();

	cout << "Type the number of the algorithm you want to run. \n";
	cout << "1) Forward Selection \n2) Backward Elimination \n3) Tony's Algorithm \n";
	cin >> choice;

	
	if (choice == 1) {
		Tony.forwardSelection();
	}
	else if (choice == 2) {
		Tony.backwardElimination();
	}
	else if (choice == 3) {
		// not quite there yet!
	}
	//Tony.print();
}

void userData::backwardElimination() {
	double accuracy = 1.0, lastAcc = -1.0, maxAcc = 0;
	int tmp, toRemove;

	vector<int>::iterator it;
	vector<int> mostAcc;
	vector<int> currSet;
	// Initialize set to contain everything
	for (int i = 1; i < 11; i++)
	{
		currSet.push_back(i);
	}

	// Set initial accuracy before removing elements
	calcNeighbor(currSet);
	maxAcc = kFold();

	cout << "Beginning Search. \n\nUsing feature(s) {";
	for (int x = 0; x < currSet.size() - 1; x++)
	{
		cout << currSet[x] << ", ";
	}
	cout << currSet[currSet.size() - 1] << "} accuracy is " << (maxAcc) << "!\n" << endl;
	mostAcc = currSet;

	// Iterate through, removing the lowest percent choice each time
	// Once we stop finding a better solution, we assume we are done
	while (lastAcc < maxAcc)
	{
		lastAcc = maxAcc;
		// Fancy output for Eamonn <3
		if (accuracy != 1) {
			cout << "\nFeature set {";
			for (int x = 0; x < mostAcc.size() - 1; x++)
			{
				cout << mostAcc[x] << ", ";
			}
			cout << mostAcc[mostAcc.size() - 1] << "} was best, accuracy is " << maxAcc << "!\n\n";
		}
		else {
			// do nothing
		}

		// Remove an element each time
		for (int i = 0; i < currSet.size() - 1; i++)
		{
			// record element being removed
			tmp = currSet[i];
			currSet.erase(currSet.begin() + i);

			// Calc accuracy after removing it
			calcNeighbor(currSet);
			accuracy = kFold();

			cout << "Using feature(s) {";
			for (int x = 0; x < currSet.size() - 1; x++)
			{
				cout << currSet[x] << ", ";
			}
			cout << currSet[currSet.size() - 1] << "} accuracy is " << (accuracy) << endl;

			// keep track of best move and element to be deleted
			if (accuracy > maxAcc) {
				maxAcc = accuracy;
				mostAcc.clear();
				mostAcc = currSet;

				it = currSet.begin();
				it = currSet.insert(it + i, tmp);
				toRemove = i;
			}
			else {				
				it = currSet.begin();
				it = currSet.insert(it + i, tmp);
			}
		}
		// if we found a better solution, it's safe to delete
		if (lastAcc < maxAcc) {
			currSet.erase(currSet.begin() + toRemove );
			mostAcc.clear();
			mostAcc = currSet;
		}
	}
	cout << "\nAccuracy has decreased upon continuing search!\nFinished search!! The best feature subset is {";
	for (int x = 0; x < mostAcc.size() - 1; x++)
	{
		cout << mostAcc[x] << ", ";
	}
	cout << mostAcc[mostAcc.size() - 1] << "}, which has an accuracy of " << maxAcc * (double)(100) << "%!\n";	
}

void userData::forwardSelection() {

	double accuracy = 1, lastAcc = -1.0, maxAcc = 0;
	bool repeat;
	vector<int> mostAcc;
	vector<int> currSet;
	// Iterate through, choosing the highest percent choice each time
	// Once we stop finding a better solution, we assume we are done
	while ( lastAcc < maxAcc)
	{
		lastAcc = maxAcc;
		// Fancy output for Eamonn <3
		if (accuracy != 1) {
			cout << "\nFeature set {";
			for (int x = 0; x < mostAcc.size() - 1; x++)
			{
				cout << mostAcc[x] << ", ";
			}
			cout << mostAcc[mostAcc.size() - 1] << "} was best, accuracy is " << maxAcc << "!\n\n";
		}
		else {
			cout << "Beginning search. \n\n";
		}
		// Set the current set to the most accurate set
		currSet = mostAcc;
		for (int i = 1; i < Data[0].size(); i++)
		{
			repeat = false;
			// No repeats!
			for (int w = 0; w < currSet.size(); w++)
			{
				if (currSet[w] == i) {
					repeat = true;
				}
			}
			if (!repeat) {
				// Push back next element for comparison
				currSet.push_back(i);
				// Set nearest neighbor
				calcNeighbor(currSet);
				// get K-fold accuracy for each one
				accuracy = kFold();

				cout << "Using feature(s) {";
				for (int x = 0; x < currSet.size() - 1; x++)
				{
					cout << currSet[x] << ", ";
				}
				cout << currSet[currSet.size()-1] << "} accuracy is " << (accuracy) << endl;

				// Keep track of best choices
				if (accuracy > maxAcc) {
					maxAcc = accuracy;
					mostAcc.clear();
					mostAcc = currSet;
					currSet.pop_back();
				}
				else {
					currSet.pop_back();
				}
			}			
		}
	}
	cout << "\nAccuracy has decreased upon continuing search!\nFinished search!! The best feature subset is {";
	for (int x = 0; x < mostAcc.size() - 1; x++)
	{
		cout << mostAcc[x] << ", ";
	}
	cout << mostAcc[mostAcc.size() - 1] << "}, which has an accuracy of " << maxAcc * (double)(100) << "%!\n";
}

// remember to store val of cols used in numSets, Tony!
void userData::calcNeighbor( vector<int> numSets ) {
	// arbitrarily set
	double total = 0, lowestEDist = 100;
	double ourVal, neigVal;
	// For each data point used
	// i = first points col
	for (int i = 0; i < Data.size(); i++)
	{				
		//...look at every other point, besides itself
		// k = second point col
		for (int k = 0; k < Data.size(); k++)
		{
			// Don't calc for itself
			if ((i != k))
			{
				for (int l = 0; l < numSets.size(); l++)
				{
					// calculate euclidean distance of every other datapoint... based on number of sets included
					// Remember, only 100 data points total
					ourVal = Data[i][numSets[l]];
					neigVal = Data[k][numSets[l]];
					total += pow((ourVal - neigVal), 2);
				}				
				// E dist is rooted at the end, if lower than current lowest, replace
				total = sqrt(total);
				if (total < lowestEDist) {
					lowestEDist = total;
					Neighbors[i][0] = Data[k][0];
					Neighbors[i][1] = lowestEDist;
				}
				// Reset total after calcing
				total = 0;
			}			
		}
		// Reset for each point
		lowestEDist = 100;
	}
}

void userData::parseData(string filename) {

	ifstream getInput(filename.c_str());
	string input, tmp;
	int i = 0, j = 0;
	while (getline(getInput, input))
	{
		// All numbers have e+000 in them, easy to find
		input = input.substr(input.find("e+000") - 9);
		// Each number is 16 characters long, so inc by 16
		for (int s = 0; s < input.size(); s+=16 ) {
			// takes input as c_string from start of string to end of num & converts to double
			tmp = input.substr(s, input.find("e+000") + 5);
			Data[i][j] = atof(tmp.c_str());
			++j;
		}
		++i;
		j = 0;
	}
}

void userData::normalize() {

	// Arbitrary values that don't appear in data
	double min = 100, max = -5, norm;
	//First we find the min and max values
	for (int i = 0; i < Data.size(); i++)
	{
		for (int j = 1; j < Data[0].size(); j++)
		{
			if (Data[i][j] < min) {
				min = Data[i][j];
			}
			else if (Data[i][j] > max) {
				max = Data[i][j];
			}
		}
	}

	norm = max - min;
	for (int i = 0; i < Data.size(); i++)
	{
		for (int j = 1; j < Data[0].size(); j++)
		{
			Data[i][j] = (Data[i][j] - min) / norm;
		}
	}
}

// Using a k of the Data size - 1
double userData::kFold() {
	double currAcc = 0;
	// double minSkip, maxSkip; only used if using a smaller k
	// k = 99 can change if desired
	int foldSize = Data.size() - 1;
	
	for (int i = 0; i < Data.size(); ++i)
	{
		for (int j = 0; j < Data.size(); j++)
		{	
			if (j == i) {
				// do nothing, skip this value
			}
			else {
				if (Data[j][0] == Neighbors[j][0]) {
					++currAcc;
				}
			}
		}
	}

	// Takes the total accuracy count and divides by the amount of nodes we checked
	return currAcc / (Data.size() * (Data.size() - 1));
}

void userData::print() {

	for ( int i = 0; i < Data.size(); i++)
	{
		for ( int j = 0; j < Data[0].size(); j++)
		{
			cout << "[" << i << "][" << j << "] val " << Data[i][j] << endl;
		}
	}
}