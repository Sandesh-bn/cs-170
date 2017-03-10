public void sortAbsolute(int[] A, int val){
    Arrays.sort(A, new comparator<Integer>(){
        public int compare(Integer o1, Integer o2){
            if (Math.abs(val - o1) < Math.abs(val - o2))
                return -1;
            else if (Math.abs(val - o1) > Math.abs(val - o2))
                return 1;
            return 0;
        }
    });
    System.out.println(Arrays.toString(A));
}

import java.util.*;
class Main {
  public static void main(String[] args) {
    System.out.println("hello world");
    Integer arr[] = {10, 5, 3, 9, 2};
    sortAbsolute(arr, 7);
  }
  
  public static void sortAbsolute(Integer[] A, int val){
    Arrays.sort(A, new Comparator<Integer>(){
        public int compare(Integer o1, Integer o2){
            if (Math.abs(val - o1) < Math.abs(val - o2))
                return -1;
            else if (Math.abs(val - o1) > Math.abs(val - o2))
                return 1;
            return 0;
        }
    });
    System.out.println(Arrays.toString(A));
}
}