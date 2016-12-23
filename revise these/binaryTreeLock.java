public class BinaryTreeLock{
	public static class BinaryTree{
		private BinaryTree left, right, parent;
		private boolean locked = false;
		private int numLockedDescendents = 0;
		
		public boolean isLocked(){
			return locked;
		}
		
		public boolean lock(){
			// we cannnot lock if node is locked
			// or it's descendents are locked.
			if (numLockedDescendents > 0 || locked)
				return false;
				
			// we  cannot lock if any of it's ancestors
			// are locked.
			
			for (BinaryTree iter = parent; iter != null; iter = iter.parent)
				if (iter.locked)
					return false;
					
			// Now you can lock it and increment all of it's 
			// ancestor descendents lock
			locked = true;
			for (BinaryTree iter = parent; iter != null; iter = iter.parent)
				iter.numLockedDescendents++;
			
			return true;
			
		}
		
		public void unlock(){
			if (locked){
				
				// unlock and decrement its ancestor's descendent lock counts.
				locked = false;
				for (BinaryTree iter = parent; iter != null; iter = iter.parent)
					iter.numLockedDescendents--;
			}
		}
		
		public BinaryTree getLeft() {
			return left;
		}
		
		public BinaryTree getRight(){
			return right;
		}
		
		public void setLeft(BinaryTree left) {
			this.left = left;
		}
		public void setRight(BinaryTree right){
			this.right = right;
		}
		
		public void setParent(BinaryTree parent){
			this.parent = parent;
		}
		
		public BinaryTree getParent(){
			return this.parent;
		}
	}
}