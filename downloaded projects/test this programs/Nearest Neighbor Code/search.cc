// CS 170: Project 2 
// Luis A. Lopez
// SID: xxx-xx-xxxx
// Instructor: Dr. Eamonn Keogh

#include "search.h"

using namespace std;

// Constructor: initializes data values
Search::Search( Neighbor *ng ) : bestAccuracy( 0.0 ),
                                 prevBestAccuracy( 0.0 )
{
   neighbor = ng;
   bestFeatureSubset.clear();
   hashTable.clear();

   cout.precision(3);
}


// Destructor
Search::~Search()
{
}


// Algorithm used to search over a possible set of states.
void Search::GeneralSearch()
{
   Node node;
   list<Node> nodes, successorNodes;
   set< int >::iterator iter;
   int numFeatures, x;
   int size;

   numFeatures = neighbor->GetNumFeatures();

   cout << "Running nearest neighbor with all " << numFeatures << " features, using 'leaving-one-out' evaluation.\n\n";
   cout << "Beginning search.\n\n";

   node.state = "";   // Initially, the first node in the queue does not contain any features.
   MakeQueue( node, nodes );

   int i=0;
   // Repeat until we have iterated a number of times (given by the # features) with no increase in accuracy,
   // or the nodes list is empty.
   while ( (i < numFeatures) && !nodes.empty() ) {   
      successorNodes.clear();

      node = RemoveFront( nodes );   // Compare the next node in the queue
      Expand( node, successorNodes );   // Expand the next node
      Enqueue( nodes, successorNodes );   // Put the successor nodes in the priority queue

      // Print out the best result of nearest neighbor, so far.
      node = nodes.front();
      cout << "Feature set {";
      x = 0;
      size = node.featureList.size();
      for (iter = node.featureList.begin(); iter != node.featureList.end(); iter++) {
         cout << *iter;
         if (x < size-1)
            cout << ",";
         x++;
      }
      cout << "} is currently the best, accuracy is  " << node.value << "%\n\n";

      if (node.value == 100 )   // Success: accuracy has reached 100%, exit the loop.
         i = numFeatures;

      i++;
   }   // end while.

   // Print out the overall best result for the nearest neighbor, using Luis Lopez' algorithm.
   cout << "Finished search!!  The best feature subset is {";
   x = 0;
   size = bestFeatureSubset.size();
   for (iter = bestFeatureSubset.begin(); iter != bestFeatureSubset.end(); iter++) {
      cout << *iter;
      if (x < size-1)
         cout << ",";
      x++;
   }
   cout << "}, which has an accuracy of " << bestAccuracy << "%\n";
}


// Insert the first node into the queue.
int Search::MakeQueue( Node current, list<Node> &nodeQueue )
{
   nodeQueue.push_back(current);

   return 0;
}


// Removes the first element from the queue, and returns it.
Node Search::RemoveFront( list<Node> &nodeQueue )
{
   Node front;

   front = nodeQueue.front();
   nodeQueue.pop_front();

   return front;
}


// Expand the next node
void Search::Expand( Node parentNode, list<Node> &successorNodes )
{
   neighbor->LuisSpecialAlgorithm( parentNode, successorNodes, bestFeatureSubset, bestAccuracy, hashTable );
}


// Insert the list of successor nodes into the priority queue, according to their value.
// Greater values (i.e. more accuracy) receive more priority.
void Search::Enqueue( list<Node> &priorityQueue, list<Node> &successorNodes )
{
   list<Node>::iterator priorityIter=NULL;
   list<Node>::iterator successorIter=NULL;

   // Traverse the list of successor nodes
   for ( successorIter = successorNodes.begin(); successorIter != successorNodes.end(); successorIter++ ) {
      // Traverse the priority queue until we find the correct postion to insert the new node.
      for ( priorityIter = priorityQueue.begin();
            priorityIter != priorityQueue.end() && (*priorityIter).value >= (*successorIter).value;
            priorityIter++ ) {
         ;
      }
      priorityIter = priorityQueue.insert(priorityIter, (*successorIter));
   }
}

