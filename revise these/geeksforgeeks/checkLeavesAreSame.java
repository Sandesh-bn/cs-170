Leaf traversal is sequence of leaves traversed from left to right. The problem is to check if leaf traversals of two given Binary Trees are same or not.

Expected time complexity O(n). Expected auxiliary space O(h1 + h2) where h1 and h2 are heights of two Binary Trees.

Examples:

Input: Roots of below Binary Trees
         1            
	/ \
       2   3      
      /   / \		  
     4   6   7

	 0
	/  \
       5    8	  
        \  / \		
        4  6  7
Output: same
Leaf order traversal of both trees is 4 6 7	 

Input: Roots of below Binary Trees
         0            
	/ \
       1   2       
      / \   	
     8   9   

	 1
	/ \
       4   3	 
        \ / \		
        8 2  9

Output: Not Same
Leaf traversals of two trees are different.
For first, it is 8 9 2 and for second it is
8 2 9
We strongly recommend you to minimize your browser and try this yourself first.
A Simple Solution is traverse first tree and store leaves from left and right in an array. Then traverse other tree and store leaves in another array. Finally compare two arrays. If both arrays are same, then return true.

The above solution requires O(m+n) extra space where m and n are nodes in first and second tree respectively.