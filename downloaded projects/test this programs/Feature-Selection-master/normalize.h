#ifndef NORMALIZE_H
#define NORMALIZE_H

#include <iostream>
#include <vector>
#include <cmath>
using namespace std;

float get_sum(vector <float> s) {
	float sum = 0;
	for (int i = 0; i < s.size(); i++) {
		sum += s.at(i);
	}
	return sum;
}

float get_sum_sq(vector <float> s) {
	float sum = 0;
	for (int i = 0; i < s.size(); i++) {
		sum += (s.at(i) * s.at(i));
	}
	return sum;
}

float get_mean(vector <float> m) {
	float sum = get_sum(m);
	return sum / m.size();
}

float get_sd(vector <float> d) {
	float sum_sq = get_sum_sq(d);
	float sum = get_sum(d);
	return (sum_sq - ((sum * sum) / d.size())) / (d.size() - 1);
}

void normalize(vector < vector <float> > &data) {
	vector <float> mean_temp;
	for (int j = 1; j < data.at(0).size(); j++) {
		mean_temp.clear();
		for (int i = 0; i < data.size(); i++) {
			mean_temp.push_back(data.at(i).at(j));
		}
		float mean = get_mean(mean_temp);
		float sd = get_sd(mean_temp);
		if (sd != 0) {
			for (int i = 0; i < data.size(); i++) {
				data.at(i).at(j) = (data.at(i).at(j) - mean) / sd;
			}
		}
	}
	cout << "Done!" << endl;
}

#endif
