 Largest Rectangle in Histogram   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 77391
Total Submissions: 303102
Difficulty: Hard
Contributors: Admin
Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.


Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].


The largest rectangle is shown in the shaded area, which has area = 10 unit.

For example,
Given heights = [2,1,5,6,2,3],
return 10.

public class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0)
            return 0;
        int i = 0, max = 0, p = 0, h = 0, w = 0;
        Deque<Integer> stack = new LinkedList<>();
        while(i < heights.length){
            if (stack.isEmpty() || heights[i] >= heights[stack.peek()])
                stack.push(i++);
            else {
                p = stack.pop();
                h = heights[p];
                w = (stack.isEmpty())?i: i - stack.peek() - 1;
                max = Math.max(h * w, max);
            }
        }
        while (!stack.isEmpty()){
            p = stack.pop();
            h = heights[p];
            w = (stack.isEmpty())?i: i - stack.peek() - 1;
            max = Math.max(h * w, max);
        }
        return max;
    }
}
