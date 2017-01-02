Merge k Sorted Lists
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
       
        
        if (lists.length == 0) return null;
        PriorityQueue<ListNode> heap = new PriorityQueue<>(lists.length, new Comparator<ListNode>(){
           public int compare(ListNode l1, ListNode l2){
               return l1.val - l2.val;
           } 
        });
        for (ListNode head: lists)
            if (head != null)
                heap.offer(head);
        
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (!heap.isEmpty()){
            curr.next = heap.poll();
            curr = curr.next;
            if (curr.next != null)
                heap.offer(curr.next);
        }
        return dummy.next;
    }
}
