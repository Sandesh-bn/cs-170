public List<TreeNode> generateTrees(int n) {
        return (n == 0)?new ArrayList<>():generateTrees(1, n);
    }
    
    public List<TreeNode> generateTrees(int start, int end){
        List<TreeNode> result = new ArrayList<TreeNode>();
        if (start > end){
            result.add(null);
            return result;
        }
        
        for (int i = start; i <= end; i++){
            List<TreeNode> leftSubTrees = generateTrees(start, i - 1);
            List<TreeNode> rightSubTrees = generateTrees(i + 1, end);
            for (TreeNode leftSubTree: leftSubTrees){
                for (TreeNode rightSubTree: rightSubTrees){
                    TreeNode root = new TreeNode(i);
                    root.left = leftSubTree;
                    root.right = rightSubTree;
                    result.add(root);
                }
            }
        }
        return result;
    }