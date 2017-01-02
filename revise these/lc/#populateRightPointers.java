public void connect(TreeLinkNode root){
    TreeLinkNode dummy = new TreeLinkNode(0);
    TreeLinkNode pre = dummy;
    while(root != null){
        if (root.left != null){
            pre.next = root.left;
            pre = pre.next;
        }
        if (root.right != null){
            pre.next = root.right;
            pre = pre.next;
        }
        root = root.next;
        if (root == null){
            pre = dummy;
            root = dummy.next;
            dummy.next = null;
        }
    }
}