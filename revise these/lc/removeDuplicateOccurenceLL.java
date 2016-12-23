Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode tail = head, runner = head.next;
        while (runner != null){
            if (runner.val == tail.val){
                while(runner != null && runner.val == tail.val)
                    runner = runner.next;
                tail.next = runner;
            }
            else {
                tail = tail.next;
                runner = runner.next;
            }
        }
        return head;
        
      
    }
}
