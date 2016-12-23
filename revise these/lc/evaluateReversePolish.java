Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Some examples:
  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
  
  
  public class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        int first = 0, second = 0;
        for (String token: tokens){
            switch(token){
                case "+":stack.push(stack.pop() + stack.pop());
                         break;
                case "-":first = stack.pop();second = stack.pop();
                         stack.push(second - first);
                         break;
                case "*":stack.push(stack.pop() * stack.pop());
                         break;
                case "/":first = stack.pop();second = stack.pop();
                         stack.push(second / first);
                         break;
                default: stack.push(Integer.parseInt(token));
                         break;
            }
        }
        return stack.pop();
    }
}
