public ListNode reverse2(ListNode head,int m, int n){
	if (head == null || head.next == null)
		return head;
	ListNode dummy = new ListNode(0);
	dummy.next = head;
	ListNode pre = dummy;
	for (int i = 0; i < m - 1; i++)
		pre = pre.next;
	
	ListNode start = pre.next;
	ListNode temp = start.next;
	for (int i = 0; i < n - m; i++){
		start.next = temp.next;
		temp.next = pre.next;
		pre.next = temp;
		temp = start.next;
	}
	return dummy.next;
}


// edge cases:
m > n
m and n out of range of values
m is 1

head is null
there is only one node
