https://segmentfault.com/a/1190000003957798
We can solve above problem recursively. At each node we need information of its parent node, if current node has value one more than its parent node then it makes a consecutive path, at each node we will compare node’s value with its parent value and update the longest consecutive path accordingly.
For getting the value of parent node, we will pass the (node_value + 1) as an argument to the recursive method and compare the node value with this argument value, if satisfies, update the current length of consecutive path otherwise reinitialize current path length by 1.


int maxLen;
public int longestConsecutive(TreeNode n){
    maxLen = 0;
    if (root == null) return maxLen;

    helper(root, root, 0);
    return maxLen;
}

public void helper(TreeNode curr, TreeNode prev, int len){
    if (curr == null) 
        return;
    
    if (pre.val + 1 == curr.val)
        len += 1;  //increase the lenght of sequence and continue in the same sequence
    else
        len = 1; // otherwise start a sequence from the current node
    
    maxLen = Math.max(maxLen, len);

    helper(curr, curr.left, len);
    helper(curr, curr.right, len);
}