// CS 170: Project 2 
// Luis A. Lopez
// SID: xxx-xx-xxxx
// Instructor: Dr. Eamonn Keogh

#include <fstream>
#include <sstream>
#include "var.h"

#ifndef NEIGHBOR_H
#define NEIGHBOR_H

using namespace std;

class Neighbor {
   public:
      Neighbor();
      ~Neighbor();
      void ReadFile( char * );
      int GetNumFeatures();
      void ForwardSelection();
      void BackwardElimination();
      void LuisSpecialAlgorithm( Node, list<Node> &, set<int> &, double &, set<string> & );
      
   private:
      void NormalizeData();
      int EuclideanDistance( int [], int, int );
      string NumToString( double );

      vector< vector<double> > element;
      double **distMatrix;
      int rows, columns;
};

#endif

