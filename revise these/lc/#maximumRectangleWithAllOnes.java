Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

For example, given the following matrix:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
Return 6.

based on tushar's video


public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0)
            return 0;
        int m = matrix.length, n = matrix[0].length;
        int histogram[] = new int[n];
        int maxArea = 0;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                int cell = matrix[i][j] - '0';
                
                if (cell == 0)
                    histogram[j] = 0;
                else
                    histogram[j] += 1;
            }
            System.out.println(Arrays.toString(histogram) + " " +  maxAreaHistogram(histogram));
            maxArea = Math.max(maxArea, maxAreaHistogram(histogram));
        }
        return maxArea;
    }
    
    public int maxAreaHistogram(int[] heights){
        if (heights == null) return 0;
        Deque<Integer> stack = new LinkedList<>();
        int i = 0, maxArea = 0, area = 0;
        
        while(i < heights.length){
            if (stack.isEmpty() || heights[stack.peek()] <= heights[i])
                stack.push(i++);
            else {
                int top = stack.pop();
                
                if (stack.isEmpty())
                    area = heights[top] * i;
                else
                    area = heights[top] * (i - stack.peek() - 1);
                maxArea = Math.max(area, maxArea);
            }
        }
        
        while(!stack.isEmpty()){
            int top = stack.pop();
            if (stack.isEmpty())
                area = heights[top] * i;
            else
                area = heights[top] * (i - stack.peek() - 1);
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }