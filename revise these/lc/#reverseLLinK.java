Reverse Nodes in k-Group
 Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

You may not alter the values in the nodes, only nodes itself may be changed.

Only constant memory is allowed.

For example,
Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k < 2) return head;
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy, tail = curr;
        dummy.next = head;
        
        while (tail != null){
            int i = 0;
            while (i < k && tail.next != null){
                i++;
                tail = tail.next;
            }
            if (i < k) return dummy.next; // we have reversed all groups of k. This group does not have k elements return head
            ListNode nextCurr = null;
            while (curr.next != tail){
                ListNode temp = curr.next;
                if (nextCurr == null) nextCurr = temp;
                curr.next = temp.next;
                temp.next = tail.next;
                tail.next = temp;
            }
            curr = nextCurr;
            tail = curr;
        }
        return dummy.next;
    }
}


