Given a binary tree with a value associated with each node, we need to choose a subset of these nodes such that sum of chosen nodes is maximum under a constraint that no two chosen node in subset should be directly connected that is, if we have taken a node in our sum then we can’t take its any children in consideration and vice versa.

We can solve this problem by considering the fact that both node and its children can’t be in sum at same time, so when we take a node into our sum we will call recursively for its grandchildren or when we don’t take this node we will call for all its children nodes and finally we will choose maximum from both of these results.
It can be seen easily that above approach can lead to solving same subproblem many times, for example in above diagram node 1 calls node 4 and 5 when its value is chosen and node 3 also calls them when its value is not chosen so these nodes are processed more than once. We can stop solving these nodes more than once by memoizing the result at all nodes.
In below code a map is used for memoizing the result which stores result of complete subtree rooted at a node in the map, so that if it is called again, the value is not calculated again instead stored value from map is returned directly.



int sumOfGrandChildren(TreeNode n, Map<Node, Integer> map){
    int sum = 0;

    if (n.left != null)
        sum += getMaxSum(n.left.left, map) + 
               getMaxSum(n.left.right, map);

    if (n.right != null)
        sum += getMaxSum(n.right.left, map) + 
               getMaxSum(n.right.right, map);
    
    return sum;
}

int getMaxSum(TreeNode node, Map<TreeNode, Integer> map){
    if (node == null)
        return 0;
    
    // if map already contains max non-adjacent sum for particular node
    if (map.containsKey(node))
        return map.get(node);
    
    // curr node + sum of grandchildren. we cannot consider children of current node
    int incl = node.val + sumOfGrandChildren(node, map);

    // excluding current node.
    int excl = getMaxSum(node.left, map) + getMaxSum(node.right, map);

    map.put(node, Math.max(incl, excl));

    return map.get(node);
}

int getMaxNonAdjacentSum(TreeNode root){
    if (root == null)
        return 0;
    Map<Node, Integer> map = new HashMap<>();
    return getMaxSum(root, map);
}