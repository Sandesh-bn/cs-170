Given a forest of balanced binary trees and two nodes, n1 and n2, find the closest common parent of n1 and n2. Nodes have parameters "parent", "left" and "right", and you cannot access the values of the nodes. If n1 and n2 are not on the same tree, return NULL. 

Try to do this in O(log(n)) time and O(1) space.


public Tree commonAncestor(Tree root, Tree p, Tree q) 
{
	if (covers(root.left, p) && covers(root.left, q))
		return commonAncestor(root.left, p, q);
	if (covers(root.right, p) && covers(root.right, q))
		return commonAncestor(root.right, p, q);
	return root;
}
private boolean covers(Tree root, Tree p) 
{
	if (root == null) 
		return false;
	if (root == p) 
		return true;
	return covers(root.left, p) || covers(root.right, p);
}