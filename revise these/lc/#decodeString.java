Given an encoded string, return it's decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

Examples:

s = "3[a]2[bc]", return "aaabcbc".
s = "3[a2[c]]", return "accaccacc".
s = "2[abc]3[cd]ef", return "abcabccdcdcdef".

public String decodeString(String s){
    Stack<String> phraseStack = new Stack<>();
    Stack<Integer> numStack = new Stack<>();
    int num = 0;
    phraseStack.push("");
    for (char ch: s.toCharArray()){

        if (Character.isDigit(ch))
            num = num * 10 + ch - '0';
        else if (ch == '['){
            numStack.push(num);
            phraseStack.push("");
            num = 0;
        }
        else if (ch == ']'){
            StringBuilder sb = new StringBuilder();
            String phrase = phraseStack.pop();
            int times = numStack.pop();
            for (int i = 0; i < times; i++)
                sb.append(phrase);
            phraseStack.push(phraseStack.pop() + sb.toString());
        }
        else
            phraseStack.push(phraseStack.pop() + ch);
    }
    return phraseStack.pop();
}