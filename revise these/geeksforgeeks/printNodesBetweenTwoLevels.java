


public void printLevels(TreeNode n, int low, int high){
    Queue<TreeNode> q = new LinkedList<>();

    TreeNode marker = new TreeNode('$'); // or some dummy value

    q.offer(n);
    q.offer(marker);;
    
    while(!q.isEmpty()){

        TreeNode n = q.poll();

        // if we have scanned all nodes at current level
        if (n == marker){
            level++;

            // no more nodes or we have exceeded the highest level
            if (q.isEmpty() || level > high)
                break;
            
            q.offer(marker);

            // skip adding left and right children of marker coz there is not any.
            continue;
        }

        if (level >= low)
            System.out.println(n.val + " " );
        if (n.left != null)
            q.offer(n.left);

        if (n.right != null)
            q.offer(n.right);
    }
}