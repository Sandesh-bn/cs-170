import java.util.*;
class Main {
  public static void main2(String[] args) {
    System.out.println("hello world");
  }
  
 public static String justify(String words[], int width) {
        
        int cost[][] = new int[words.length][words.length];
        int N = words.length;
        
        for (int i = N - 1; i >= 0; i--){
          int len = words[i].length();
          if (words[i].length() <= width)
            cost[i][i] = (int)Math.pow(width - len, 2); 
          for (int j = i + 1; j < N; j++){
            len += 1 + words[j].length();
            if (len <= width)
              cost[i][j] = (int)Math.pow(width - len, 2);
            else
            cost[i][j] = Integer.MAX_VALUE;
          }
        }
        
        for (int[] arr: cost)
          System.out.println(Arrays.toString(arr));
        //minCost from i to len is found by trying
        //j between i to len and checking which
        //one has min value
        int minCost[] = new int[N];
        int result[] = new int[N];
        for(int i = N-1; i >= 0 ; i--){
            minCost[i] = cost[i][N-1];
            result[i] = N;
            for(int j=N-1; j > i; j--){
                if(cost[i][j-1] == Integer.MAX_VALUE){
                    continue;
                }
                if(minCost[i] > minCost[j] + cost[i][j-1]){
                    minCost[i] = minCost[j] + cost[i][j-1];
                    result[i] = j;
                }
            }
        }
        int i = 0;
        int j;
        
        System.out.println("Minimum cost is " + Arrays.toString(minCost));
        System.out.println("\n");
        //finally put all words with new line added in 
        //string buffer and print it.
        StringBuilder builder = new StringBuilder();
        do{
            j = result[i];
            for(int k=i; k < j; k++){
                builder.append(words[k] + " ");
            }
            builder.append("\n");
            i = j;
        }while(j < words.length);
        
        return builder.toString();
    }
    
    public static void main(String args[]){
        String words13[] = {"Tushar","likes","to","write","code","at", "free", "time"};
        String words1[] = {"Tushar", "roy", "likes","to","code"};
        String words12[] = {"This", "is", "an", "example", "of", "text", "justification."};
       // TextJustification awl = new TextJustification();
        System.out.println(justify(words1, 12));
    }
}