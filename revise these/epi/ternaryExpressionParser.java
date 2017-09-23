http://bookshadow.com/weblog/2016/10/23/leetcode-ternary-expression-parser/
public class parseTernary(String exp){
	if (exp == null || exp.length() == 0)
		return "";
	Deque<Character> stack = new LinkedList<>();
	for (int i = exp.length() - 1; i >= 0; i--){
		char c = exp.charAt(i);
		
		// push the true value and false value to stack
		// push ?
		// if the character before '?' is T. push the last popped non : character
		// otherwise push the earliest popped non : character
		if (!stack.isEmpty() && stack.peek() == '?'){
			stack.pop(); // pop '?'
			char first = stack.pop(); // 'T' value;
			stack.pop(); // pop :
			char second = stack.pop(); // 'F' value
			if (ch == 'T')
				stack.push (first);
			else
				stack.push(second);
		}
		else
			stack.push(ch);
	}
	return String.valueOf(stack.peek());
}



