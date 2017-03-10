class Main {
  public static void main(String[] args) {
    System.out.println("hello world");
    QuickSortDoubleLL list = new QuickSortDoubleLL();
        list.head = new ListNode(10);
        list.head.next = new ListNode(30);
        list.head.next.next = new ListNode(3);
        list.head.next.next.next = new ListNode(4);
        list.head.next.next.next.next = new ListNode(20);
        list.head.next.next.next.next.next = new ListNode(5);
         
         
        ListNode node = null;
        //node = list.mergeSort(list.head);
         QuickSortDoubleLL.quickSort(list.head);
         QuickSortDoubleLL.printList(list.head);
        System.out.println("Linked list after sorting :");
        //list.print(node);
  }
}

class ListNode{
    int data;
    ListNode prev, next;
    ListNode(int d){
        this.data = d;
        prev = next = null;
    }

}
class QuickSortDoubleLL{
    ListNode head;

    static ListNode partition(ListNode l, ListNode h){
        int x = l.data;
        ListNode i = l.next;
        ListNode j = h;
        while(true){
            while(i != null && i.data < x){
                i = i.next;
                if ((i == h) || (i != null && h.next == i))break;
            }
            while(j != null && j.data >= x){
                j = j.prev;
                if ((j == l) || (j != null && j.next == l))break;
            }
           // if (i == j || (j != null && j.next == i))break;
           if ((i == j || i == null || j == null) || j.next == i) break;
            int t = i.data;
            i.data = j.data;
            j.data = t;
        }
        if (j == null || l == null)return j;
        int t = j.data;
        j.data = l.data;
        l.data = t;
        return j;

    }

    static void quickSort(ListNode l, ListNode h){
        if (h != null && l != null && l != h && l != h.next){
            ListNode temp = partition(l, h);
            if (temp != null){
              quickSort(l, temp.prev);
              quickSort(temp.next, h);
            }
        }
    }

    static void quickSort(ListNode head){
        ListNode curr = head;
        while(curr.next != null){
            curr = curr.next;
        }
        quickSort(head, curr);
    }

    static void printList(ListNode head){
        ListNode c = head;
        while (c != null){
            System.out.println(c.data + " ");
            c = c.next;
        }
    }

}


    //public static void main(String[] a){
        
    //}
