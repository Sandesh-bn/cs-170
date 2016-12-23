// CS 170: Project 2 
// Luis A. Lopez
// SID: xxx-xx-xxxx
// Instructor: Dr. Eamonn Keogh


#include <iostream>
#include <iomanip>
#include <string>
#include <vector>
#include <list>
#include <set>

#ifndef VAR_H
#define VAR_H

using namespace std;

struct Node {
   string state;   // State of the subset; for storing it in the hash table
   set<int> featureList;   // Subset of features to use
   double value;      // The value of the current state
};

#endif
