for example: . means current folder, .. means parent folder. So "/a/b/.." means from a to b folder, and from b to b's parent folder, finally we can simplified it as "/a"


For example, as best as I can tell, it seems that foo/bar and foo//bar both point to the same place.
Yes. This is common because software sometimes concatenates a path assuming the first part was not terminated with a forward slash, so one is thrown in to make sure (meaning there may end up being two or more). foo///bar and foo/////bar also point to the same place as foo/bar. A nice function for a path manipulation library would be one which reduces any number of sequential slashes to one (except at the beginning of a path, where it may be used in an URL-ish way, or, as Stephane points out, for any unspecified special purpose).

Also, ~ usually stands for the user's home directory


... is a valid directory name in Unix, so the output is /...

path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"

path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"
path = "/../", => "/"
path = "/home//foo/", => "/home/foo"

(1) Use a stack to store the path.
      (2) Use a int flag to store the '/' pair
      (3) First remove the "//" in the path.
      (4) meets ".", do nothing, meets ".." pop stack if not empty, other strings push into stack.
	  
	  

Corner Cases:

Did you consider the case where path = "/../"?
In this case, you should return "/".
Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
In this case, you should ignore redundant slashes and return "/home/foo".



There are three types of paths:

relative paths like foo, foo/bar, ../a, .. They don't start with / and are relative to the current directory of the process making a system call with that path.
absolute paths like /, /foo/bar or ///x. They start with 1, or 3 or more /, they are not relative, are looked up starting from the / root directory.
POSIX allows //foo to be treated specially, but doesn't specify how. Some systems use that for special cases like network files. It has to be exactly 2 slashes.
Other than at the start, sequences of slashes act like one.

~ is only special to the shell, it's expanded by the shell, it's not special to the system at all. How it's expanded is shell dependent. Shells do other forms of expansions like globbing (*.txt) or variable expansion /$foo/$bar or others. As far as the system is concerned ~foo is just a relative path like _foo or foo.

Things to bear in mind:

foo/ is not the same as foo. It's closer to foo/. than foo (especially if foo is a symlink) for most system calls on most systems (foo// is the same as foo/ though).
a/b/../c is not necessarily the same as a/c (for instance if a/b is a symlink). Best is not to treat .. specially.
it's generally safe to consider a/././././b the same as a/b though.


Using a stack to store all the names, when encountering “..”, then pop out the stack, when encountering a regular name, push the name into the stack, when encountering “.” or other characters, just ignore and continue scanning the path. After finishing scanning, just print the remaining names in the stack, note in unix, a path always start from “/”, followed by the name structure in the stack, and don’t append “/” in the last name in the stack.


Path             Return
/..              /
/home/           /home
/home/./user     /home/user
/home/../user    /user
/home//user      /home/user

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