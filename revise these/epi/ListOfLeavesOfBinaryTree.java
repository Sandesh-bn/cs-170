// Given a binary tree add all leaves to a linked list in left-right order.

public static List<Integer> createListOfLeaves(BinaryTree root){
	List<Integer> leaves = new LinkedList<>();
	addLeavesLeftToRight(node, leaves);
	return leaves;
}

private static void addLeavesLeftToRight(BinaryTree node, List<Integer> leaves){
	if (node != null){
		if (node.left == null && node.right == null)
				leaves.add(node.val);
		else {
			addLeavesLeftToRight(node.left, leaves);
			addLeavesLeftToRight(node.right, leaves);
		}
	}
}

//Solution can be found here: https://github.com/adnanaziz/epicode/blob/master/java/src/main/java/com/epi/ConnectLeavesBinaryTree.java

