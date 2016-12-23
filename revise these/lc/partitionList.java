Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;
        ListNode dummyLess = new ListNode(0);
        ListNode dummyMore = new ListNode(0);
        ListNode curr = head, more = dummyMore, less = dummyLess;
        while (curr != null){
            if (curr.val < x){
                less.next = curr;
                less = less.next;
            }
            else {
                more.next = curr;
                more = more.next;
            }
            curr = curr.next;
        }
        less.next = dummyMore.next;
        more.next = null;
        return dummyLess.next;
        
        
    }
}

