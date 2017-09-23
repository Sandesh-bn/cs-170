class AllOne{
    class Node{
        int val;
        Node prev, next;
        Set<String> keyset;
        public Node(int v){
            this.val = v;
            keyset = new HashSet<>();
        }
    }
    private Node head;
    private Node tail;
    Map<String, Node> map;
    public AllOne(){
        head = new Node(0);
        tail = new Node(Integer.MAX_VALUE);
        map = new HashMap<>();
    }

    public void inc(String key){
        Node curr = map.get(key);
        if (curr == null){
            Node next = head.next;
            if (next.val == 1){
                next.keyset.add(key);
                map.put(key, next);
            }
            else {
                Node newNode = new Node(1);
                newNode.keyset.add(key);
                map.put(key, newNode);
                newNode.pre = head;
                head.next = newNode;
                newNode.next = next;
                next.pre = newNode;
            }
        }
        else {
            Node next = curr.next;
            curr.keyset.remove(key);
            if (next.val == curr.val + 1){
                next.keyset.add(key);
                map.put(key, next);
            }
            else {
                Node newNode = new Node(curr.val + 1);
                newNode.keyset.add(key);
                map.put(key, newNode);
                curr.next = newNode;
                newNode.pre = curr;
                newNode.next = next;
                next.pre = newNode;
            }

            if(curr.keyset.isEmpty() && curr.val != Integer.MAX_VALUE){
                Node prev = curr.pre;
                prev.next = newNode;
                newNode.pre = prev;
            }
        }
    }

    public void dec(String key){
        Node curr = map.get(key);
        if (curr == null){
            return;
        }
        else {
            curr.keyset.remove(key);
            Node prev = curr.pre;
            Node next = curr.next;
            if (curr.val == 1){
                remove(key);
            }
            else {
                if (prev.val == curr.val - 1){
                    map.put(key, prev);
                    prev.keyset.add(key);
                }
                else{
                    Node newNode = new Node(curr.val - 1);
                    newNode.keyset.add(key);
                    curr.pre = newNode;
                    newNode.next = curr;
                    prev.next = newNode;
                    newNode.pre = prev;
                    map.put(key, newNode);
                    prev = newNode;
                }

                if (curr.keyset.isEmpty() && curr.val != Integer.MAX_VALUE){
                    prev.next = next;
                    next.prev = prev;
                }
            }
        }
    }
}