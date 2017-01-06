http://www.geeksforgeeks.org/check-binary-tree-subtree-another-binary-tree-set-2/
https://www.youtube.com/watch?v=J29eAoniIsw


boolean isSubTree(TreeNode t1, TreeNode t2){
	StringBuilder t1PreOrderString = new StringBuilder();
	StringBuilder t2PreOrderString = new StringBuilder();
	
	getPreOrderString(t1, t1PreOrderString);
	getPreOrderString(t2, t2PreOrderString);
	
	return t1PreOrderString.indexOf(t2PreOrderString.toString()) != -1;
}

void getPreOrderString(TreeNode node, StringBuilder sb){
	if (node == null){
		sb.append("X");
		return;
	}
	sb.append(node.data + " ");
	getPreOrderString(node.left, sb);
	getPreOrderString(node.right, sb);
}


// without extra space
class TreeNode{
	int value;
	TreeNode left, right;
	TreeNode(int k){
		value = k;
	}
}

class Test {
	// compare if a tree is a asubtree based on reference
	public static boolean isSubTreeRef(TreeNode n1, TreeNode n2){

		// if t2 is null, then t2 is a subtree of t2

		if (t2 == null) 
			return true;

	    // t2 is non-null and t1 is null, so t2 cannot be subtree of t1
		if (t1 == null)
			return false;

		// compare if they are equal reference or 
		// compare t2 with t1's children'

		return (t1 == t2) 
			|| isSubTreeRef(t1.left , t2)
			|| isSubTreeRef(t1.right, t2);
	}

	// compare the values;
	public static boolean ifSubTreeValue(TreeNode t1, TreeNode t2){


		if (t2 == null) return true;

		if (t1 == null) return false; // since t2 is non-null

		// check the values;
		if (t1.value == t2.value){
			//if root have equal values check if their subtrees are same

			if (ifSubTreeValue(t1.left, t2.left) && ifSubTreeValue(t1.right, t2.right))
				return true;
		}

		// otherwise check if t2 is subtree of one of t1's child
		return ifSubTreeValue(t1.left, t2) || ifSubTreeValue(t1.right, t2);


	}

	public static void main(String[] args){

		/*
				1
			2		3
				  4    5

		*/
		TreeNode t1 = new TreeNode(1);
		t1.left = new TreeNode(2);t1.right = new TreeNode(3);
		t1.right.left = new TreeNode(4);
		t1.right.right = new TreeNode(5);

		
	}
}