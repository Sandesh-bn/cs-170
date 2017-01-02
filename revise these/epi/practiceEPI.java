@@DOUBLE LINKED LIST

class DLL{
    class Node{
        Node next, prev;
        Node(String val){
            this(val, null, null);
        }
        Node(String val, Node next, Node prev){
            value = val;
            next = next;
            prev = prev;
        }
    }

    private Node first, last;
    int count;
    public DLL(){
        first = null;
        last = null;
        count = 0;
    }

    public int size(){
        return count;
    }

    public void add(String s){
        if (first == null){
            first = new Node(0);
            last = first;
        }
        else {
            last.next = new Node(s, null, last);
            last = alst.next;
        }
        count++;
    }
    public void insert(int index, String s){
        if (index < 0 || index > size) throw else
        if (index == 0){
            if (first == null)
                add(s);
            else {
                Node p = first;
                first = new Node(s, p, null);
            }
        }
        else if (index == count){
            add(s);
        }
        else {
            Node pred = first;
            for (int i = 0; i < index - 1; i++)
                pred = pred.next;
            Node succ = pred.next;
            pred.next = new Node(s, succ, pred);
            if (succ == null)
                last = pred.next;
            else    
                succ.prev = pred.next;
        }
        count++;
    }
    public void remove(int index){
        if (count == 0 || index < 0 || index >= count) throw else
        if (index == 0){
            first = first.next;
            if (first == null)
                last = null;
        } 
        Node t = first;
        for (int i = index; i <= index; i++)
            t = t.next;
        Node pred = t.prev;
        Node succ = t.next;
        if (pred == null)
            first = t.next;
        else
            pre.next = succ;
        if (succ == null)  
            last = prev;
        else
            last.prev = pred;
        count--;
    }

    public boolean remove(String ele){
        if (count == 0) return false;
        Node t = first;
        while(t != null && !t.value.equals(ele))
            t = t.neext;
        Node pred = t.prev;
        Node suc = t.next;
        if (pred == null)
            first = succ;
        else
            pred.next = succ;
        if (succ = null)
            last = pred;
        else
            succ.prev = pred;
    }
}
// ENCODE DECODE STRING

public String decode(String value){
    StringBuilder sb = new StringBuilder();
    int i = 0;
    while (i < value.length()){
        int num = 0;
        while(Character.isDigit(value.charAt(i))){
            num = num * 10 + value.charAt(i) - '0';
            i++;
        }
        i++;
        result.append(value.substring(i, i + num + 1));
        i = i + num + 1;
    }
}
// FIND COMMON IN 3 ARRAYS
public void findCommong(int[] a1, int[] a2, int[] a3){
    int i = 0, j = 0, k = 0;
    while(i < a1.length && j < a2.length && k < a3.length){
        if (a1[i] == a2[j] == a3[k]){
            print i, j, k
            i++;j++;k++;
        }
        if (a1[i] < a2[j])
            i++;
        if (a2[j] < a3[k])
            j++;
        else
            k++;
    }
}


// FIRST ELEMENT LARGER THAN TARGET

public int leftMost(int[] A, int x){
    int l = 0, high = A.length - 1, res = -1;
    while(l <= high){
        int mid = (l + high)/2;
        if (A[mid] > x)
            high  = mid - 1;
        if (A[mid] == x)[
            high = mid - 1;
            res = mid;
        ]
        else
            low = mid + 1;
    }
}


public class Vec2d{
    List<Integer> lsit = new ArrayList<>();
    int i = 0;
    public Vec2d(List<List<Integer>> l){
        for (List ele: l)
            list.addAll(ele);
    }
    public int next(){
        return list.get(i++);
    }
    public boolean hasNext(){
        return i < list.size();
    }
}
// PRINT ALL LEAFS



///QUEUE USING HEAP

//FLIP BIT

// RANDOM ARRAY

// K SMALLEST PAIRS


// LEXICAL ORDER



//LIST LEAVES 


// MAGIC INDEX


// LOGGER RATE LIMITER

// SUB ARRAY SUM K// 


// MEETING ROOM\


//MERGE SORT


// MIN BATTERY CAPACITY


// MIN MOVES TO MAKE ELEMENT EQUAL


// MISSING RANGES


// MOVING AVERAGE


// MULTI SEARCH


// ONE EDIT DISTANCE


// PAIRWISE SWAP


// PRINT ALL LEAFS


// QUUEUE USING HEAP

// QUEUEU USING LL


// REPLACE AND REMOVE


// STACK ARRAY

/// REVERSE AWORDS

// RUN LENTH ENCODING


// RUNNING MEDIAN


// SHUFFLE CARDS


// ALL ELEMENTS APPEAR THRICE


// SMALLEST DIFFERENCE


// SORT STACK


// SPARSE SEARCH

// STACK USING LL

// STACK ARRAY


// TWO SUM DATA STRUCUTRE

// WELL AND GATE

// ZIG ZAG ITERATOR

