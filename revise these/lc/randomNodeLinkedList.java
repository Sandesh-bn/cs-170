Given a singly linked list, return a random node's value from the linked list. Each node must have the same probability of being chosen.

Follow up:
What if the linked list is extremely large and its length is unknown to you? Could you solve this efficiently without using extra space?

Example:

// Init a singly linked list [1,2,3].
ListNode head = new ListNode(1);
head.next = new ListNode(2);
head.next.next = new ListNode(3);
Solution solution = new Solution(head);

// getRandom() should return either 1, 2, or 3 randomly. Each element should have equal probability of returning.
solution.getRandom();

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    private int size;
    private ListNode head;
    private Random rand;
    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        this.head = head;
        ListNode curr = head;
        this.rand = new Random();
        while (curr != null){
            this.size += 1;
            curr = curr.next;
        }
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        int j = rand.nextInt(this.size);
        ListNode randomNode = head;
        while(j> 0){
            randomNode = randomNode.next;
            j--;
        }
        return randomNode.val;
    }
}


/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */