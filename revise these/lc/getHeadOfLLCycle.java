public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                while(fast != head){
                    c++;
                    head = head.next;
                    fast = fast.next;
                }
                
                return head;
            }
        }
        return null;
    }
}