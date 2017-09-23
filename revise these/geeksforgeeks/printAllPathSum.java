Print all k-sum paths in a binary tree
A binary tree and a number k are given. Print every path in the tree with sum of the nodes in the path as k.
A path can start from any node and end at any node, i.e. they need not be root node and leaf node; and negative numbers can also be there in the tree.

Examples:

Input : k = 5  
        Root of below binary tree:
           1
        /     \
      3        -1
    /   \     /   \
   2     1   4     5                        
        /   / \     \                    
       1   1   2     6    
                       
Output :
3 2 
3 1 1 
1 3 1 
4 1 
1 -1 4 1 
-1 4 2 
5 
1 -1 5 

http://www.geeksforgeeks.org/print-k-sum-paths-binary-tree/
public static void main (String[] args) {
    //code
    GFG obj=new GFG();
    NodeTree root=new NodeTree(1);
    NodeTree leftroot=new NodeTree(3);
    NodeTree rightroot=new NodeTree(-1);
    root.left=leftroot;
    root.right=rightroot;
    
    leftroot.left=new NodeTree(2);
    leftroot.right=new NodeTree(1);
    leftroot.right.left=new NodeTree(1);
    
    rightroot.left=new NodeTree(4);
    rightroot.right=new NodeTree(5);
    
    rightroot.left.left=new NodeTree(1);
    rightroot.left.right=new NodeTree(2);

    rightroot.right.right=new NodeTree(6);

    obj.printAllPaths(root);
}

static int k=5;

public void printAllPaths(TreeNode root){
    List<Integer> arr = new ArrayList<>();
    helper(root, arr, 0);
    if (root.left != null)
        printAllPaths(root.left);
    if (root.right != null)
        printAllPaths(root.right);
}

public void helper(TreeNode root, List<Integer> list, int sum){
    list.add(root.data);
    sum += root.val;
    if (sum == k){
        System.out.println("paths : " + list);
        list.remove(list.size() - 1);
        return;
    }

    if (root.left == null && root.right == null){
        list.remove(list.size() - 1);
        return;
    }

    if (root.left != null){
        helper(root.left, list, sum);
    }

    if (root.right != null){
        helper(root.right, list, sum);
    }

    list.remove(list.size() - 1);
}