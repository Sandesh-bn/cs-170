http://www.geeksforgeeks.org/split-a-circular-linked-list-into-two-halves/


class LinkedList{
    class ListNode{
        int data;
        ListNode next, prev;
        ListNode(int d){
            data = d;
            next = prev = null;
        }
    }

    void splitList(){
        ListNode slow = fast = head;

        if (head == null) return;

        while(fast.next != head && fast.next.next != head){
            fast = fast.next.next;
            slow = slow.next;
        }

        // if there are even element, move fast
        if (fast.next.next == head)
            fast = fast.next;

        // head for first half
        ListNode head1 = head;

        // head for second half
        if (head.next != head)
            ListNode head2 = slow.next;
        
        // make second half circular
        fast.next = slow.next;

        // make first half circular
        slow.next = head;

    }
}