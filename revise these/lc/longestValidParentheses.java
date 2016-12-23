if ch is '('
	then push count to stack.
else if stack is not empty
	count = count + (stack.pop()) + 1;
else // ))))))))))))
	count = 0;
	clear stack