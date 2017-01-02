

Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1

public boolean hasPathSum(TreeNode node, int sum){
    if (node == null) return false;
    if (node.left == null && node.right == null && sum == node.val)
        return true;
    int rem = sum - root.val;
    return hasPathSum(node.left, rem ) || hasPathSum(node.right, rem);
}


Binary Tree Maximum Path Sum
Given a binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.

For example:
Given the below binary tree,

       1
      / \
     2   3
Return 6.

int maxSoFar = 0;
public int maxPathSum(TreeNode root){
    if (root == null) return 0;
    helper(root);
    return maxSoFar;
}
public int helper(TreeNode node){
    if (node == null) return 0;
    int leftSubTreeSum = Math.max(helper(root.left), 0);
    int rightSubTreeSum = Math.max(helper(root.right), 0);

    maxSoFar = Math.max(maxSoFar, node.val + leftSubTreeSum + rightSubTreeSum);

    return node.val + Math.max(leftSubTreeSum, rightSubTreeSum);
}




Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:

   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:

["1->2->5", "1->3"]

public List<String> printAllPaths(TreeNode root){
    List<String> res = new ArrayList<>();
    if (root == null) return res;
    dfs(res, "", root);
    return res;
}

public void dfs(List<String> res, String path, TreeNode root){
    if (root.left == null && root.right == null)
        res.add(path + root.val);
    if (root.left != null)
        dfs(res, path + root.val + "->", root.left);
    if (root.right != null)
        dfs(res, path + root.val + "->", root.right);
}




Sum Root to Leaf Numbers
Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25.

public int sumRootToLeaf(TreeNode root){
    if (root == null) return 0;
    Deque<TreeNode> st = new LinkedList<>();
    st.push(root);
    while(!st.isEmpty()){
        TreeNode n = st.pop();
        if (n.right != null){
            n.right.value = (n.value * 10) + n.right.value;
            st.push(n.right);
        }
        if (n.left != null){
            n.left.value = (n.value * 10) + n.left.value;
            st.push(n.left);
        }
        if (n.left == null && n.rigth == null)
            res += n.val;

    }
    return res;
}

Given a binary tree and a sum, find all root-to-leaf paths where each paths sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]

public List<List<Integer>> pathSum(TreeNode root, int sum){
    List<List<Integer>> res = new ArrayList<>();
    if (root == null) return res;
    dfs(res, new ArrayList<>(), root, sum);
    return res;   
}

public void dfs(List<List<Integer>> res, List<Integer> path, TreeNode curr, int sum){
    if (curr == null)
        return;
    int rem = sum - root.val;
    path.add(curr.val);

    if (curr.left == null && curr.right == null && rem == 0)
        res.add(new ArrayList<>(path));
    dfs(res, path, curr.left, rem);
    dfs(res, path, curr.right, rem);
    path.remove(path.size() - 1);
}


PATH SUM 3
You are given a binary tree in which each node contains an integer value.

Find the number of paths that sum to a given value.

The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).

The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.

Example:

root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1

Return 3. The paths that sum to 8 are:

1.  5 -> 3
2.  5 -> 2 -> 1
3. -3 -> 11 
https://discuss.leetcode.com/topic/64415/easy-to-understand-java-solution-with-comment/2
https://discuss.leetcode.com/topic/67782/easy-java-solution
