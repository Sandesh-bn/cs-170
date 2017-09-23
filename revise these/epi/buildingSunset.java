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
			while (!stack.isEmpty() && stack.peek() <= currHeight)
				stack.pop();
			stack.push(currHeight);
		}
	}
	System.out.println(stack);	
}

// 7 4 8 2 9
// output -> 9, 8, 7 . stack prints from bottom to top.


You are given with a series of buildings that have windows facing west. The buildings
are in a straight line, and if a building b is to the east of a building whose height is
greater than or equal to b,it is not possible to view the sunset from b.
Problem 8.6: Design an algorithm that processes buildings as they are presented to
it and tracks the buildings that have a view of the sunset. The number of buildings
is not known in advance. Buildings are given in east-to-west order and are specified
by their heights. The amount of memory your algorithm uses should depend solely
on the number of buildings that have a view; in particular itshould not depend on
the number of buildings processed.
