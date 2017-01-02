Simplify Path   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 70844
Total Submissions: 297083
Difficulty: Medium
Contributors: Admin
Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"
public class Solution {
    public String simplifyPath(String path) {
        Set<String> skip = new HashSet<>();
        skip.add("..");skip.add(".");skip.add("");
        Deque<String> stack = new LinkedList<>();
        for (String dir: path.split("/")){
            if (dir.equals("..") && !stack.isEmpty())
                stack.pop();
            else if (!skip.contains(dir))
                stack.push(dir);
        }
        StringBuilder sb = new StringBuilder();
        for (String dir: stack)
            sb.insert(0, "/" + dir);
        return (sb.length() > 0)?sb.toString():"/";
    }
}