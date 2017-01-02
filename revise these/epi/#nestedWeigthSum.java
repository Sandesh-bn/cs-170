Given a nested list of integers, return the sum of all integers in the list weighted by their depth.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Example 1:
Given the list [[1,1],2,[1,1]], return 10. (four 1's at depth 2, one 2 at depth 1)

Example 2:
Given the list [1,[4,[6]]], return 27. (one 1 at depth 1, one 4 at depth 2, and one 6 at depth 3; 1 + 4*2 + 6*3 = 27)


 /**
 2  * // This is the interface that allows for creating nested lists.
 3  * // You should not implement it, or speculate about its implementation
 4  * public interface NestedInteger {
 5  *
 6  *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 7  *     public boolean isInteger();
 8  *
 9  *     // @return the single integer that this NestedInteger holds, if it holds a single integer
10  *     // Return null if this NestedInteger holds a nested list
11  *     public Integer getInteger();
12  *
13  *     // @return the nested list that this NestedInteger holds, if it holds a nested list
14  *     // Return null if this NestedInteger holds a single integer
15  *     public List<NestedInteger> getList();
16  * }
17  */



public int depthSum(List<NestedInteger> nestedList) {
    return helper(nestedList, 1);
}

private int helper(List<NestedInteger> list, int depth)
{
    int ret = 0;
    for (NestedInteger e: list)
    {
        ret += e.isInteger()? e.getInteger() * depth: helper(e.getList(), depth + 1);
    }
    return ret;
}

bfs: 0(n) time O(k) space k is max depth of the list.