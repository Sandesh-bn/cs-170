public int maxHistogram(int heights[]){
    Deque<Integer> st = new LinkedList<>();
    int maxArea = 0, area = 0, i = 0;

    while(i < heights.length){
        if (stack.isEmpty() || heights[stack.peek()] <= heights[i])
            stack.push(i++);
        else {
            int top = stack.pop();
            
            if (stack.isEmpty())
                area = heights[top] * i;
            else
                area = heights[top] * (i - stack.peek() - 1);
            maxArea = Math.max(maxArea, area);
        }
    }
    while(!stack.isEmpty()){
        int top = stack.pop();
        if (stack.isEmpty())
            area = heights[top] * i;
        else 
            area = heights[top] * (i - stack.peek() - 1);
        maxArea = Math.max(maxArea, area);
    }
    return maxArea;
}