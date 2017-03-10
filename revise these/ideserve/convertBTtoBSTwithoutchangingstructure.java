https://www.youtube.com/watch?v=wBFttOncVUc
public TreeNode convert(TreeNode root){
    Stack<TreeNode> st = new Stack<>();
    List<Integer> val = new ArrayList<>();

    TreeNode curr = root;
    while(curr != null || st.isEmpty()){
        while(curr != null){
            curr = curr.left;
        }
        curr = st.pop();
        vals.add(curr.val);
        curr = curr.right;
    }
    Collections.sort(vals);
    TreeNode curr = root;
    int i = 0;
    while(curr != null || st.isEmpty()){
        while(curr != null){
            curr = curr.left;
        }
        curr = st.pop();
        curr.val = vals.get(i++);
        curr = curr.right;
    }
}