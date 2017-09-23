
public int ProductOfUmOfLeavsAtSameLevel(TreeNode node){
    if (node == null)
        return 0;

    int prod = 1;

    Queue<TreeNode> q = new LinkedList<>();
    q.offer(node);

    while(!q.isEmpty()){

        int size = q.size();
        int levelSum = 0
        boolean leafFound = false;

        for (int i = 0;i < size; i++){
            Node n = q.poll();

            if (isLeaf(n)){
                leaffound = true;
                levelSum += n.val;
            }

            if (n.left != null)
                q.offer(n.left);
            if (n.right != null)
                q.offer(n.right);
        }

        if (leafFound)
            prod *= levelSum;


    }
    return prod;
}