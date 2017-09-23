


public class Test{
    public static void main(String[] args){

    }

    public static CircularList insert(CircularList head, int n){
        if(head == null) // empty list
            return new CircularList(n);
        else if (head.next == head){  // only one element
            head.next = new CircularList(n);
            head.next.next = head;
            return head.value < n ? head: head.next;
        }
        else if (n < head.value){ // element to be inserted is the smaller than first element
            CircularList current = head;

            while(current.next != head){
                current = current.next;
            }
            current.next = new CircularList(n);
            current.next.next = head;
            return current.next;
        }
        else {
            CircularList curr = head;
            while(curr.next != head  && curr.next.value <= n)
                curr = curr.next;
            
            CircularList succ = curr.next;
            curr.next = new CircularList(n);
            curr.next.next = succ;
            return head;
        }

    }
}
class CircularList{
    int value;
    CircularList next;
    public CircularList(int k){
        this.value = k;
        this.next =this;
    }

    public void printList(){
        if (this == null) return;
        CircularList current = this;

        do {
            Systen.out.println(current.value + " ");
            current = current.next;
        }while(current != this);
    }
}