// implement priority queue

public class MinHeap{
    private List<Integer> items;
    public Heap(){
        items = new ArrayList<>();
    }

    private void siftUp(){
        int k = items.size() - 1;
        while (k > 0){
            int p = (k - 1)/2;
            int item = items.get(k);
            int parent = items.get(p);
            if (item < parent){
                items.set(k, parent);
                items.set(p, item);
                k = p;
            }
            else
                break;
        }
    }

    private void siftDown(){
        int k = 0;
        int l = 2 * k + 1;
        while (l < items.size()){
            int max = l, r = l + 1;
            if (r < items.size()){
                if (items.get(r) > items.get(l))
                    max = r;
            }
            if (items.get(k) > items.get(max)){
                T temp = items.get(k);
                items.set(k, items.get(max));
                items.set(max, temp);
                k = max;
                l = 2 * k + 1;
            }
            else
                break;
        }
    }

    private int poll(){
        if (items.size() == 0)throw exception;
        if (items.size() == 1)
            return items.get(0);
        
        int root = items.get(0);
        items.set(0, items.get(items.size() - 1));
        siftUp();
        return root;
    }

    private void offer(int val){
        items.add(val);
        siftUp();
    }

    public int size(){
        return items.size();
    }

    public boolean isEmpty(){
        return items.size() == 0;
    }
}



public class Heap<T extends Comparable<T>> {
    private List<T> items;

    public Heap(){
        items = new ArrayList<>();
    }

    private void siftUp(){
        int k = items.size() - 1;
        while(k > 0){
            int p = (k - 1)/2;
            T item = items.get(k);
            T parent = items.get(p);
            if (items.compareTo(parent) > 0){
                items.set(k, parent);
                items.set(p, item);
                k = p;
            }
            else
                break;
        }
    }

    private void siftDown(){
        int k = 0;
        int l = 2 * k + 1;
        while (l < items.size()){
            int max = l, r = l + 1;
            if (r < items.size()){
                if (items.get(r).compareTo(items.get(l)) > 0){
                    max = r;
                }
            }
            
            if (items.get(k).compareTo(items.get(max)) < 0){
                T temp = items.get(k);
                items.set(k, items.get(max));
                items.set(max, temp);
                k = max;
                l = 2 * k + 1;
            }
            else    
                break;
        }
    }

    public T poll(){
        if (items.size() == 0)
            throw new Exception();
        if (items.size() == 1)
            return items.remove(0);
        
        T root = items.get(0);
        items.set(0, items.size() - 1);
        siftUp();
        return root;
    }
    public void offer(T value){
        items.add(value);
        siftUp();
    }

    public int size(){
        return items.size();
    }

    public boolean isEmpty(){
        return items.size() == 0;
    }

}