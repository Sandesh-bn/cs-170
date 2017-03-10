https://www.youtube.com/watch?v=nyR8K63F2KY
http://stackoverflow.com/questions/4606984/maximum-number-of-characters-using-keystrokes-a-ctrla-ctrlc-and-ctrlv/22542395#22542395

 public static void main(String[] arg){
    System.out.println(maxChar(8));
  }
  
  public static int maxChar(int n){
    int[] dp = new int[n + 1];
    for (int i = 0; i < n; i++){
      dp[i + 1] = Math.max(dp[i + 1], dp[i] + 1);
      for (int j = i + 3; j < Math.min(i + 7, n + 1); j++){
        dp[j] = Math.max(dp[j], dp[i] * (j - i - 1));
      }
    }
    return dp[n];
  }