/*
http://www.practice.geeksforgeeks.org/problem-page.php?pid=515
*/
trace the algo with the examples in above link
public void displayBuildings(int[] heights){
	Stack<Integer> stack = new Stack<>();
	for (int i = heights.length - 1; i >= 0; i--){
		int currHeight = heights[i];
		if (stack.isEmpty() || stack.peek() > currHeight)
			stack.push(currHeight);
		else {
			while (!stack.isEmpty() && stack.peek() >= currHeight)
				stack.pop();
			stack.push(currHeight);
		}
	}
	System.out.println(stack);	
}

// 7 4 8 2 9
// output -> 9, 8, 7 . stack prints from bottom to top.