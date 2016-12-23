//hanoi
/*
We first check if the number of poles, n is equal to one. If so, the base case solution will be used which consists of moving a disc from the start peg to the end peg. If not, the recursive solution is used which consists of two recursive calls to the same procedure solve(). When we need to move n-1 discs from the start pole to the auxiliary pole, the auxiliary pole becomes the end pole and the end pole becomes the auxiliary pole. That is why we have written 
solve(n - 1, start, end, auxiliary)
instead of 
solve(n - 1, start, auxiliary, end)


Next we print ' start -> end ' which corresponds to moving the largest disc at the bottom from the start peg to the end peg. 

Finally, we have recursive invocation of solve(). Here, the auxiliary peg becomes the start peg and the start peg becomes the auxiliary peg. 
*/

class Main {
  public static void solve(int n, String start, String auxiliary, String end) {
       if (n == 1) {
           System.out.println(start + " -> " + end);
       } else {
           solve(n - 1, start, end, auxiliary);
           System.out.println(start + " -> " + end);
           solve(n - 1, auxiliary, start, end);
       }
   }

   public static void main(String[] args) {
       //TowersOfHanoi towersOfHanoi = new TowersOfHanoi();
       System.out.print("Enter number of discs: ");
       
       int discs =3;
       solve(discs, "A", "B", "C");
   }
}