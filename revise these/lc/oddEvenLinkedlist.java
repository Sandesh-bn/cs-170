public ListNode oddEvenList(ListNode head){
	if (head == null || head.next == null)
		return head;
	ListNode firstOdd = head, firstEven = head.next, odd = head, even = firstEven;
	
	while (even != null && even.next != null){
		
		odd.next = even.next;
		odd = odd.next;
		even.next = odd.next;
		even = even.next;
	}
	odd.next = firstEven;
	even.next = null;
}