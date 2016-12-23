// CS 170: Project 2 
// Luis A. Lopez
// SID: xxx-xx-xxxx
// Instructor: Dr. Eamonn Keogh

#include "var.h"
#include "neighbor.h"

#ifndef SEARCH_H
#define SEARCH_H

using namespace std;


class Search {
   public:
      Search( Neighbor * );
      ~Search();
      void GeneralSearch();
      
   private:
      int MakeQueue( Node current, list<Node> &priorityQueue );
      Node RemoveFront( list<Node> &priorityQueue );
      void Expand( Node parentNode, list<Node> &successorNodes );
      void Enqueue( list<Node> &priorityQueue, list<Node> &successorNodes );

      Neighbor *neighbor;
      set< string > hashTable;
      set< int > bestFeatureSubset;
      double bestAccuracy;
      double prevBestAccuracy;
};

#endif

