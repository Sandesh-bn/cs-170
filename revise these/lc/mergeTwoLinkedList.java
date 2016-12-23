Sort a linked list in O(n log n) time using constant space complexity.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head){
        if (head == null || head.next == null)
            return head;
        
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondHalf = sortList(slow.next);
        slow.next = null;
        ListNode firstHalf = sortList(head);
        return merge(firstHalf, secondHalf);
    }
    
    
    public ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                curr.next = l1;
                l1 = l1.next;
            }
            else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        
        curr.next = (l1 == null)?l2: l1;
        return dummy.next;
    }
   
   
   
}
