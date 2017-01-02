public ListNode rotate(ListNode head, int k){
	if (head == null || head.next = null || k = 0)
		return head;
	ListNode fast = head;
	int len = 0;
	while (fast.next != null){
		len++;
		fast = fast.next;
	}
	k = k % len;
	fast.next = head;
	for (int i = 0;  i< len - k ; i++)
		fast = fast.next;
	head = fast.next;
	fast.next = null;
	return head;
}