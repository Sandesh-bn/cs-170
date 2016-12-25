Remove all elements from a linked list of integers that have value val.

Example
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
 
public ListNode removeElements(ListNode head, int x){
	while(head != null && head.val == x)
		head = head.next;
	if (head == null || head.next == null)
		return head;
	ListNode tail = head, runner = head.next;
	while (runner != null){
		if (runner.val == x){
			while (runner != null && runner.val == x)
				runner = runner.next;
		}
		tail.next = runner;
		else {
			tail = tail.next;
			runner = runner.next;
		}
			
	}
	return head;
}