# Feature Selection
CS170 - Intro to Artificial Intelligence project.

Given a data set with two classes, the program will find the best features suited for classification.
Classification will be done with the nearest neighbor algorithm and tested with one-out cross validation.
It includes forward selection, backward elimination, and a custom search that should be more fast or optimal than the previous two.

## Forward Selection
Start with 0 features, add one at a time with a greedy search for best accuracy.

## Backward Elimination
Start with n features, remove one at a time with a greedy search for best accuracy.

## Custom Search
We first begin populating our heap with features based on NN and then initialize the our set
with the first feature in our heap.
After this, we begin popping features from our heap and testing it.
If it improves our accuracy then we add it to our set.
The number of times we pop from our heap should be limited based on the number of features.
If doing this does not improve our accuracy we reorder the heap based on our current set and if
it does not show any signs of improvement we stop.
This search is faster because it assumes that the next X best features are going to be added.
By testing it right away we avoid extensively testing other features.
However, if it does not improve our accuracy we would have to reorder the heap, in the worst
case it would have the same runtime as FS.
But by limiting the number of times we reorder our heap we can make it faster than both FS and BE.
Despite checking less it will also perform just as good as FS.
