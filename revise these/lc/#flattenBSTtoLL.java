Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6

public void flatten(TreeNode root){
    if (root == null) return;
    Dequeu<TreeNode> st = new LinkedList<>();
    TreeNode curr = root;
    while(!st.isEmpty() || curr != null){
        if (curr.right != null)
            st.push(curr.right);
        if (curr.left != null){
            curr.right = curr.left;
            curr.left = null;
        }
        else
            curr.left = st.pop();
        curr = curr.right;
    }
}