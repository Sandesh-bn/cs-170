import java.util.*;
class Main {
  public static void main(String[] args) {
    System.out.println("hello world");
    int[] arr = {1, 2, 3, 4, 5};
    int[] arr2 = {4, 5, 6};
    List<List<Integer>> crossProductList = crossProduct(arr, arr2);
    System.out.println(crossProductList.toString());
    
  }
  
  public static List<List<Integer>> crossProduct(int[] arr1, int[] arr2){
    List<List<Integer>> result = new ArrayList<>();
    for (int i = 0; i < arr1.length; i++){
      for (int j = 0; j < arr2.length; j++){
        List<Integer> pairs = new ArrayList<>();
        pairs.add(arr1[i]);
        pairs.add(arr2[j]);
        result.add(pairs);
      }
    }
    return result;
  }
}