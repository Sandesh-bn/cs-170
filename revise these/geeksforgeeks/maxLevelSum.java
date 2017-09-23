Input :               4
                    /   \
                   2    -5
                  / \    /\
                -1   3 -2  6
Output: 6
Explanation :
Sum of all nodes of 0'th level is 4
Sum of all nodes of 1'th level is -3
Sum of all nodes of 0'th level is 6
Hence maximum sum is 6

Input :          1
               /   \
             2      3
           /  \      \
          4    5      8
                    /   \
                   6     7  
Output :  17

public int maxLevelSum(TreeNode root){
    if (root == null)
        return 0;
    
    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);

    while(!q.isEmpty()){
        int size = q.size();

        int sum = 0;
        for (int i = 0; i < size; i++){
            TreeNode n = q.poll();
            sum += n.val;

            if (n.left != null)
                q.offer(n.left);
            if (n.right != null)
                q.offer(n.right);
        }
        result = Math.max(sum, result);
    }
    return result;
}