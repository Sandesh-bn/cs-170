class Main {
  public static void main(String[] args) {
    System.out.println("hello world");
    LinkedList list = new LinkedList();
        list.head = new ListNode(10);
        list.head.next = new ListNode(30);
        list.head.next.next = new ListNode(3);
        list.head.next.next.next = new ListNode(4);
        list.head.next.next.next.next = new ListNode(20);
        list.head.next.next.next.next.next = new ListNode(5);
         
         
        ListNode node = null;
        node = list.mergeSort(list.head);
        System.out.println("Linked list after sorting :");
        list.print(node);
  }
}

class ListNode{
        int data;
        ListNode prev, next;
        ListNode(int d){
            this.data = d;
            next = prev = null;
        }
    }
class LinkedList{
    
    static ListNode head;

    void print(ListNode node){
        ListNode curr = node;
        while(curr != null){
            System.out.println(curr.data + " ");
            curr = curr.next;
        }
    }

    ListNode split(ListNode head){
        ListNode fast =head, slow = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode temp = slow.next;
        slow.next = null;
        return temp;
    }

    ListNode mergeSort(ListNode head){
        if (head == null || head.next == null)  
            return head;
        ListNode secondHalf = split(head);
        ListNode firstHalf = mergeSort(head);
        secondHalf = mergeSort(secondHalf);
        return merge(firstHalf, secondHalf);
    }

    ListNode merge(ListNode first, ListNode second){
        if (first == null) return second;

        if (second == null)return first;

        if (first.data < second.data){
            first.next = merge(first.next, second);
            first.next.prev = first;
            first.prev = null;
            return first;
        }
        else {
            second.next = merge(first, second.next);
            second.next.prev = second;
            second.prev = null;
            return second;
        }
    
    }

    //public static void main(String[] a){
        
    //}
}