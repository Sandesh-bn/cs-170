https://www.youtube.com/watch?v=uFso48YRRao

public static void printnextLargest(int[] A){
    Stack<Integer> st = new Stack<>();
    int N = A.length;
    for(int i = 0; i < N; i++){
        if (st.isEmpty() || st.peek() > A[i])
            st.push(A[i]);
        else {
            while(!st.isEmpty() && st.peek() <= A[i])
                System.out.println(st.pop() + "->" + A[i]);
            st.push(A[i]);
        }
    }
}



public static void main(String[] aa){
      int[] a = {5, 3, 2, 10, 6, 8, 14, 12, 74};
      printnextLargest(a);
  }

output
2->10
3->10
5->10
6->8
8->14
10->14
12->74
14->74