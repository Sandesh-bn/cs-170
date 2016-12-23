public void reverseK(ListNode head){
	if (head == null || k < 2 || head.next == null)
		return head;
	
	ListNode dummy = new ListNode(0);
	dummy.next = head;
	ListNode curr = dummy;
	ListNode tail = curr;
	while (tail != null){
		int i = 0;
		while(i < k && tail.next != null){
			i++;
			tail = tail.next;
		}
		if (i < k)
			return dummy.next;
		
		ListNode nc = null;
		
		while (curr.next != null){
			ListNode temp = curr.next;
			
			if (nc == null)
				nc = temp;
			
			curr.next = temp.next;
			temp.next = tail.next;
			tail.next = temp;
		}
		curr = nc;
		tail = nc;
	}
	return dummy.next;
}

/*
if k > length of linkedlist you will first find out the length of linkedlist
and then set k = k % len;
*/