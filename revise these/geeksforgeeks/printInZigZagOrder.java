// http://www.geeksforgeeks.org/perfect-binary-tree-specific-level-order-traversal/

public void print(TreeNode r){

    if (r == null)
        return;
    System.out.println(node.val + " ");

    if (r.left != null)
        System.out.println(node.left.val + " ");
    else
        return;

    if (r.right != null)
        System.out.println(node.right.val + " ");

    
    Queue<TreeNode> q = new LinkedList<>();
    q.offer(node.left);
    q.offer(node.right);

    while(!q.isEmpty()){

        Node first = q.poll();
        Node second = q.poll();

        System.out.println(first.left.val + " " + second.right.val + " " + first.right.val + " " + second.left.val);


        // if there are grandchildren
        if (first.left.left != null){
            q.offer(first.left);
            q.offer(second.right);
            q.offer(first.right);
            q.offer(second.left);
        }
    }

}