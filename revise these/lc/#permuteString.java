import java.util.*;
class Main {
  public static void main(String[] args) {
    System.out.println("hello world");
    System.out.println(permute("abc"));
  }
  
  static List<String> res =  new ArrayList<>();
  public static List<String> permute(String val){
    permute(val.toCharArray(), 0, val.length() - 1);
    
    return res;
  }
  public static void permute(char[] A, int low, int high){
    if (low == high){
      StringBuilder sb = new StringBuilder();
      for (char ch: A)sb.append(ch);
      res.add(sb.toString());
    }
    
    else {
      for (int i = low; i <= high; i++){
        swap(A, low, i);
        permute(A, low + 1, high);
        swap(A, low, i);
      }
    }
  }
  
  public static void swap(char[] A, int i, int j){
    char temp = A[i];
    A[i] = A[j];
    A[j] = temp;
  }
}