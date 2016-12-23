 The input consists ofa very long sequence ofnumbers. Eachnumber
is at most k positions away from its correctly sorted position. Design an algorithm
that outputs the numbers in the correct order and uses O(k) storage, independent of
the number of elements processed.

maintain a heap of size K + 1. whenever a new element arrives poll the smallest element from the heap and write it to output array

no number is off by more than k positions from its correctly sorted
position, if more than k numbers greater than a given number have arrived and all
the numbers smaller than the given number that arrived have been written, we can
be sure that there are no more other smaller numbers that are going to arrive. Hence
it is safe to write the given numbers.