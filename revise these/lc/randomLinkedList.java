A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.


/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return head;
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode curr = head;
        while(curr != null){
            map.put(curr, new RandomListNode(curr.label));
            curr = curr.next;
        }
        for (Map.Entry<RandomListNode, RandomListNode> entry: map.entrySet()){
            RandomListNode duplicateNode = entry.getValue();
            duplicateNode.next = map.get(entry.getKey().next);
            duplicateNode.random = map.get(entry.getKey().random);
        }
        return map.get(head);
    }
}