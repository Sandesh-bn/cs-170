import java.util.*;
public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                int ele = matrix[i][j];
                if (pq.size() < k)
                    pq.offer(ele);
                else if (pq.peek() > ele){
                    pq.poll();
                    pq.offer(ele);
                }
            }
        }
        return pq.poll();
        /*
        if (k == 1)return matrix[0][0];
        int[] aux = new int[matrix.length * matrix[0].length];
        int p = 0;
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++)
                aux[p++] = matrix[i][j];
        }
        Arrays.sort(aux);
        return aux[k - 1];
        */
        
    }
}