public static Stack<Integer> sortStack(Stack<Integer> orig){
		   Stack<Integer> aux = new Stack<Integer>();
		   
		   while (!orig.isEmpty()){
		      int top = orig.pop();
		      
		      while(!aux.isEmpty() && aux.peek() < top){
		         orig.push(aux.pop());
		      }
		      aux.push(top);
		   
		   }
		   
		   
		   return aux;

		}
		
Time is O(N ^ 2) time and O(N) space.