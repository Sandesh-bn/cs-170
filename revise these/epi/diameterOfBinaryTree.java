http://www.geeksforgeeks.org/diameter-of-a-binary-tree/
The diameter of a tree T is the largest of the following quantities:

* the diameter of T’s left subtree
* the diameter of T’s right subtree
* the longest path between leaves that goes through the root of T (this can be computed from the heights of the subtrees of T)

class TreeNode{
	int data;
	TreeNode left, right;
	public TreeNode(int value){
		this.data = value;
	}
}

class BinaryTree{
	TreeNode root;
	int diameter(TreeNode root){
		if (root == null)
			return 0;
		int leftHeight = getHeight(root.left);
		int rightHeight = getHeight(root.right);
		
		int leftDiameter = diameter(root.left);
		int rightDiameter = diamter(root.right);
		
		return Math.max(leftHeight + rightHeight + 1,
						Math.max(leftDiameter, rightDiameter));
	}
	
	int diameter(){
		return diameter(root);
	}
	
	static int height(TreeNode curr){
		if (curr == null)
			return 0;
		return 1 + Math.max(height(curr.left), height(curr.right));
	}
	
	
    public static void main(String args[])
    {
        /* creating a binary tree and entering the nodes */
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
 
        System.out.println("The diameter of given binary tree is : "
                           + tree.diameter());
    }
}