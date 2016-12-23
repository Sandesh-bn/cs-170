// CS 170: Project 2
// Luis A. Lopez
// SID: xxx-xx-xxxx
// Instructor: Dr. Eamonn Keogh 


#include <iostream>
#include <string>
#include "neighbor.h"
#include "search.h"


using namespace std;


int main( int argc, char *argv[] )
{
   int opt=0;

   try {
      if (argc < 2) {
         throw string("format is 'nearestNeighbor <filename>'");
      }

      // Main menu
      cout << "\n\n";
      cout << "Welcome to Luis Lopez's Feature Selection Algorithm.\n";
      cout << "Type the number of the algorithm you want to run.\n";
      cout << "    1) Forward Selection\n";
      cout << "    2) Backward Elimination\n";
      cout << "    3) Luis' Special Algorithm\n";
      cout << "       option: ";
      cin >> opt;

      Neighbor ng;
      ng.ReadFile( argv[1] );
      if ( opt == 1 ) {   // Forward Selection
         ng.ForwardSelection();
      } else if ( opt == 2 ) {   // Backward Elimination
         ng.BackwardElimination();
      } else if ( opt == 3 ) {   // Luis' Special Algorithm
         Search s( &ng );
         s.GeneralSearch();
      } else
         throw string("invalid search option!");

   } catch( string e) {
      cout << "NearestNeighbor: " << e << endl;
   }

   return 0;
}

