// CS 170: Project 2 
// Luis A. Lopez
// SID: xxx-xx-xxxx
// Instructor: Dr. Eamonn Keogh

#include "neighbor.h"

using namespace std;

// Constructor: initializes data values
Neighbor::Neighbor() : rows( 0 ),
                       columns( 0 )
{
   cout.precision(3);
}


// Destructor
Neighbor::~Neighbor()
{
}



// Reads the file and stores it in a vector.  The first column describes the type
// of the element, and following columns are the features of this element.
void Neighbor::ReadFile( char *fileName )
{
   vector< double > newrow;
   ifstream file;
   string token="";
   char ch;
   int i=0, r=0, fileSize;

   // Open the file
   file.open(fileName, ifstream::in);   
   // Get the size of the file
   file.seekg( 0, ios::end );
   fileSize = file.tellg();
   file.seekg( 0, ios::beg );
   // Check the file is open
   if (!file.is_open()) 
      throw string("the file could not be opened!");

   element.push_back(newrow);   // Create a new vector row
   while ( i < fileSize ) {   // Read the file
      token = "";

      ch = file.get();
      i++;
      while (ch != ' ' && ch != '\n' && i < fileSize) {   // New token found
         token += ch;
         ch = file.get();
         i++;
      }

      if (token != "")   // Insert token into the element vector
         element[r].push_back( atof(token.c_str()) );
 
      if (ch == '\n' && i < fileSize) {   // New data point - advance to the next vector row
         element.push_back(newrow);
         r++;
      }
   }

   rows = element.size();
   columns = element[0].size();

   cout << "\nThis dataset has " << columns-1 << " features (not including the class attribution), with ";
   cout << rows << " instances.\n\n";

   NormalizeData();
}



// Z-normalizes the data
void Neighbor::NormalizeData()
{
   double dataMean;
   double stdDev;

   cout << "Please wait while I normalize the data... ";
   for (int j=1; j<columns; j++) {
      dataMean = 0.0;
      stdDev = 0.0;

      // Compute the mean
      for (int i=0; i<rows; i++) {
         dataMean += element[i][j];
      }
      dataMean = dataMean / rows;

      // Compute the standard deviation: s = sqrtRoot{Sigma[(x - mean)^2] / (n-1) }
      for (int i=0; i<rows; i++) {
         stdDev += (element[i][j] - dataMean) * (element[i][j] - dataMean);
      }
      stdDev = sqrt(stdDev / (rows-1));

      // Normalize the data for this column
      for (int i=0; i<rows; i++) {
         element[i][j] = (element[i][j] - dataMean) / stdDev;
      }
   }
   cout << "Done!\n\n";
}


// Compute the Euclidean distance between a new element to be classified
// and its neighbors.  For simplicity, the Euclidean distance is squared.
int Neighbor::EuclideanDistance( int featureList[], int size, int k )
{
   double distance=0.0, bestDistance=0.0;
   int closestNeighbor=0;
   bool isFirstNeighbor=true;

   for (int i=0; i < rows; i++) {   // Calculate the distance to each neighbor.
      distance = 0.0;

      if (i != k) {
         for (int j=0; j < size; j++) {   // Calculate the Euclidean destance with all the features.
            distance += (element[k][featureList[j]] - element[i][featureList[j]]) *
                        (element[k][featureList[j]] - element[i][featureList[j]]);
         }

         if (isFirstNeighbor) {   // Keep track of the closest neighbor.
            bestDistance = distance;
            closestNeighbor = i;
            isFirstNeighbor = false;
         } else if (distance < bestDistance) {
            bestDistance = distance;
            closestNeighbor = i;
         }
      }   // end if
   }   // end for

   if (element[k][0] == element[closestNeighbor][0])   // Return 1 if the new data point is correctly classified.
      return 1;
   else
      return 0;
}


// Starts with an empty set and progressively selects new features,
// which improve the accuracy of the nearest neighbor algorithm.
void Neighbor::ForwardSelection()
{
   int featureList[columns-1], availFeatures[columns-1], bestFeature=0;
   double bestAccuracy=0.0, betterAccuracy=0.0, accuracy=0.0;
   vector<int> bestFeatureSubset;

   cout << "Running nearest neighbor with all " << columns-1 << " features, using 'leaving-one-out' evaluation.\n\n";
   cout << "Beginning search.\n\n";

   for (int x=0; x < columns-1; x++)   // Store all the possible features in the availFeatures array
      availFeatures[x] = x+1;

   for (int i=1; i < columns; i++) {   // How many features to use
      betterAccuracy = 0.0;

      for (int j=0; j < columns-i; j++) {   // Traverse the available features
         featureList[i-1] = availFeatures[j];

         accuracy = 0.0;
         for (int k=0; k < rows; k++) {   // Use k-fold cross validation, w/ k=1 for each row of the element matrix
            accuracy += EuclideanDistance( featureList, i, k );
         }
         accuracy = accuracy / rows * 100;

         cout << "         Using feature(s) {";   // Print accuracy results
         for (int x=0; x<i-1; x++)
            cout << featureList[x] << ",";
         cout << featureList[i-1] << "} accuracy is " << accuracy << "%" << endl;

         if (accuracy > betterAccuracy) {
            betterAccuracy = accuracy;
            bestFeature = j;
         }
      }   // end for

      featureList[i-1] = availFeatures[bestFeature];   // Expand the features with the best accuracy only.
      availFeatures[bestFeature] = availFeatures[columns-1-i];   // Eliminate the selected feature from ava. features.
      cout << endl;

      if (betterAccuracy > bestAccuracy) {   // Remember the best feature subset and its acuracy.
         bestAccuracy = betterAccuracy;
         bestFeatureSubset.clear();
         for (int x=0; x < i; x++) 
            bestFeatureSubset.push_back(featureList[x]);
      } else 
         cout << "(Warning, accuracy has decreased!  Continuing search in case of local maxima)" << endl;

      // Print the subset, which currently has the best accuracy.
      cout << "Feature set {";
      for (int x=0; x < i-1; x++) 
         cout << featureList[x] << ",";
      cout << featureList[i-1] << "} was best, accuracy is  " << betterAccuracy << "%\n\n";
   }   // end for

   // Print the subset with the overall best accuracy.
   cout << "Finished search!!  The best feature subset is {";
   for (uint x=0; x < bestFeatureSubset.size()-1; x++)
      cout << bestFeatureSubset[x] << ",";
   cout << bestFeatureSubset[bestFeatureSubset.size()-1] << "}, which has an accuracy of " << bestAccuracy << "%\n";
}


// Start with all element in the set, and progressively eliminate elements,
// one at a time, to increase the accuracy of the nearest neighbor classifier.
void Neighbor::BackwardElimination()
{
   int featureList[columns-1], bestFeature=0, lastFeature=0, eliminatedFeature=0;
   double bestAccuracy=0.0, betterAccuracy=0.0, accuracy=0.0;
   vector<int> bestFeatureSubset;
                                    
   cout << "Running nearest neighbor with all " << columns-1 << " features, using 'leaving-one-out' evaluation.\n\n";
   cout << "Beginning search.\n\n";

   for (int x=0; x < columns-1; x++)   // Store all the features in the featureList
      featureList[x] = x+1;

   for (int i=columns-1; i > 0; i--) {   // How many features to use
      betterAccuracy = 0.0;           
      lastFeature = featureList[i];                                                                                       

      for (int j=i; j >= 0; j--) {   // Traverse the features
         // Eliminate another feature from the feature set, by swapping the values of
         // the last featureList value w/ that of the eliminated value.
         eliminatedFeature = featureList[j];
         featureList[j] = lastFeature;   

         accuracy = 0.0;
         for (int k=0; k < rows; k++) {   // Use k-fold cross validation, w/ k=1 for each row of the element matrix
            accuracy += EuclideanDistance( featureList, i, k );
         }
         accuracy = accuracy / rows * 100;
                                                                                                                             
         cout << "         Using feature(s) {";   // Print accuracy results
         for (int x=0; x < i-1; x++)
            cout << featureList[x] << ",";
         cout << featureList[i-1] << "} accuracy is " << accuracy << "%" << endl;
                                                                                                                             
         if (accuracy > betterAccuracy) {   // Remember the feature, whose elimination gives the best accuracy.
            betterAccuracy = accuracy;
            bestFeature = j;
         }
         featureList[j] = eliminatedFeature; // Reset the featureList

         if (i == columns-1) {   // Don't eliminate any features, in the first iteration.
            j = -1;
         }
      }   // end for
                                                                                                                             
      featureList[bestFeature] = lastFeature;   // Eliminate the feature, whose eliminate gave the best accuracy.
      cout << endl;
                                
      // Remember the better feature subset, among the subsets w/ the same number of elements, and its accuracy.                                                                                             
      if (betterAccuracy > bestAccuracy) {  
         bestAccuracy = betterAccuracy;
         bestFeatureSubset.clear();
         for (int x=0; x < i; x++)
            bestFeatureSubset.push_back(featureList[x]);
      } else
         cout << "(Warning, accuracy has decreased!  Continuing search in case of local maxima)" << endl;

      // Print the subset with the better accuracy.
      cout << "Feature set {";
      for (int x=0; x < i-1; x++)
         cout << featureList[x] << ",";
      cout << featureList[i-1] << "} was best, accuracy is  " << betterAccuracy << "%\n\n";
   }   // end for
                                                   
   // Print the subset with the global best accuracy.                                                                          
   cout << "Finished search!!  The best feature subset is {";
   for (uint x=0; x < bestFeatureSubset.size()-1; x++)
      cout << bestFeatureSubset[x] << ",";
   cout << bestFeatureSubset[bestFeatureSubset.size()-1] << "}, which has an accuracy of " << bestAccuracy << "%\n";
}


// Uses a priority queue to select the feature subset with the best accuracy.
// It then adds a new feature element to this subset, and enqueues the resulting subsets.
void Neighbor::LuisSpecialAlgorithm( Node node, list<Node> &successorNodes, 
                         set<int> &bestFeatureSubset, double &bestAccuracy, set<string> &hashTable )
{
   int arraySize = node.featureList.size()+1;
   int featureList[arraySize], bestFeature=0, x;
   double betterAccuracy=0.0, accuracy=0.0;
   pair< set<int>::iterator, bool > isNewFeature;
   pair< set<string>::iterator, bool > isNewState;
   set< int >::iterator iter;

   // Copy the contents of the node set to a temp array.
   x=0;
   for (iter = node.featureList.begin(); iter != node.featureList.end(); iter++) {
      featureList[x] = *iter;
      x++;
   }

   betterAccuracy = 0.0;
   for (int i=1; i < columns; i++) {   // Traverse the list of features
      isNewFeature = node.featureList.insert(i);

      if (isNewFeature.second) {   // Put this feature subset in the hash table.
         node.state = "";
         for (iter = node.featureList.begin(); iter != node.featureList.end(); iter++)   
            node.state += NumToString( *iter );   
         isNewState = hashTable.insert(node.state);   
      }

      if (isNewFeature.second && isNewState.second) {   // Verify this new feature is not already in the set featureList.
         featureList[arraySize-1] = i;   // Store it in a temp array.
         accuracy = 0.0;

         for (int k=0; k < rows; k++) {   // Use k-fold cross validation, w/ k=1 for each row of the element matrix
            accuracy += EuclideanDistance( featureList, arraySize, k );
         }
         accuracy = accuracy / rows * 100;   // Compute the accuracy
         node.value = accuracy;

         cout << "         Using feature(s) {";   // Print accuracy results
         for (int x=0; x < arraySize-1; x++)
            cout << featureList[x] << ",";
         cout << featureList[arraySize-1] << "} accuracy is " << accuracy << "%" << endl;

         if (accuracy > betterAccuracy) {   // Remember the better accuracy, so far.
            betterAccuracy = accuracy;
            bestFeature = i;
         }

         successorNodes.push_back(node);   // Store the node in the list of successor nodes
         node.featureList.erase(i);   // Reset the featureList set.
      } else if (isNewFeature.second && !isNewState.second)
         node.featureList.erase(i);
   }   // end for

   cout << endl;
   if (betterAccuracy > bestAccuracy) {   // Remember the best feature subset and its acuracy. 
      bestAccuracy = betterAccuracy;
      bestFeatureSubset = node.featureList; 
      bestFeatureSubset.insert( bestFeature );
   } else
      cout << "(Warning, accuracy has decreased!  Continuing search in case of local maxima)" << endl;
}


// Convert a double number to a string
string Neighbor::NumToString( double num ) 
{
   stringstream theString;
   theString << num;

   return theString.str();
}


// Return the total number of possible features
int Neighbor::GetNumFeatures()
{
   return (columns - 1);
}
