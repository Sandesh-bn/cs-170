
http://www.geeksforgeeks.org/print-extreme-nodes-of-each-level-of-binary-tree-in-alternate-order/
public void printExtremeNodes(TreeNode node){
    if (node == null)
        return;

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    boolean flag = false;
    while(!queue.isEmpty()){
        int size = queue.size();
        int n = size;

        for (int i = 0; i < n; i++){
            Node curr = queue.poll();

            if (curr.left != null)
                queue.offfer(curr.left);
            
            if (curr.right != null)
                queue.offer(curr.right);
            
            if (flag && i == size - 1)
                System.out.println(curr.val + " ");

            if (!flag && i == 0)
                System.out.println(curr.val + " ");
        }
        flag = !flag;
    }
}