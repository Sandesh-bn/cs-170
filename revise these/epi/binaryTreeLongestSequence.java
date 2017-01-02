https://segmentfault.com/a/1190000003957798
Given a binary tree, find the length of the longest consecutive sequence path.

The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The longest consecutive path need to be from parent to child (cannot be the reverse).

For example,

   1
    \
     3
    / \
   2   4
        \
         5 
Longest consecutive sequence path is 3-4-5, so return 3.

   2
    \
     3
    / 
   2    
  / 
 1 
Longest consecutive sequence path is 2-3,not3-2-1, so return 2.


We can solve above problem recursively. At each node we need information of its parent node, if current node has value one more than its parent node then it makes a consecutive path, at each node we will compare node’s value with its parent value and update the longest consecutive path accordingly.
For getting the value of parent node, we will pass the (node_value + 1) as an argument to the recursive method and compare the node value with this argument value, if satisfies, update the current length of consecutive path otherwise reinitialize current path length by 1.
int maxLen;
public int longestConsecutive(TreeNode root){
	if (root == null)
		return 0;
	maxLen = 0;
	helper(root, root, 0);
	return maxLen;
}
public void helper(TreeNode pre, TreeNode curr, int len){
	if (curr == null)
		return;
	if (pre.val + 1 == curr.val)
		len += 1;//increase the lenght of sequence and continue in the same sequence
	else
		len = 1;// otherwise start a sequence from the current node
	maxLen = Math.max(len, maxLen);
	
	helper(curr, root.left, len);
	helper(curr, root.right, len);
}