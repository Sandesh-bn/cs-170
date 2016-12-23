public class MinHeap {
	private int[] array;
	private int count;
	private static final int DEFAULT_SIZE = 10;
	
	public MinHeap(){
		this(DEFAULT_SIZE);
	}
	
	public MinHeap(int size){
		array = new int[size];
		this.count = 0;
		for (int i = 0; i < size; i++)
			array[i] = Integer.MAX_VALUE;
	}
	
	public int getLeftChildIndex(int index){
		return 2 * index + 1;
	}
	
	public int getRightChildIndex(int index){
		return 2 * index + 2;
	}
	
	public int getParentIndex(int index){
		return (index - 1)/2;
	}
	
	public void insert(int value){
		if (count == array.length)
			throw new RuntimeException();
		
		count++;
		int index = count - 1;
		array[index] = value;
		siftUp(index);
		
	}
	
	public void siftUp(int index){
		if (index == 0)
			return;
		
		int parentIndex = getParentIndex(index);
		
		if ((array[parentIndex] > array[index]) && parentIndex >= 0){
			swap(index, parentIndex);
			index = parentIndex;
			siftUp(index);
		}
	}
	
	
	public void swap(int index1, int index2){
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}
	
	public void insertWithoutRecursion(int value){
		count++;
		int index = count - 1;
		
		array[index] = value;
		
		int temp;
		
		int parentIndex = getParentIndex(index);
		
		while ((array[parentIndex] > array[index]) && parentIndex >= 0){
			swap(index, parentIndex);
			parentIndex = getParentIndex(index);
		}
	}
	
	public int getMin(){
		if (count == 0)
			throw new RuntimeException();
		
		int ret = array[0];
		array[0] = array[count - 1];
		array[count - 1] = Integer.MAX_VALUE; // this is a dummy value
		count--;
		
		if (count > 0)
			siftDown(0);
		return ret;
	}
	
	public void siftDown(int index){
		
		
		int left = getLeftChildIndex(index);
		int right = getRightChildIndex(index);
		int smaller = -1;
		
		if (left < count && right < count)
			smaller = (array[left] < array[right])? left: right;
		else if(left < count)
			smaller = left;
		else if (right < count)
			smaller = right;
		else
			return;
		
		while (smaller >= 0 && array[smaller] < array[index]){
			swap(smaller, index);
			smaller = index;
		}
				
		
	}
	
	public String toString(){
		StringBuilder ret = new StringBuilder();
		for (int i = 0; i < array.length; i++){
			if (array[i] == Integer.MAX_VALUE)
				ret.append("? ");
			else
				ret.append(array[i] + " ");
		}
		return ret.toString();
	}
	
	
	public static void main(String[] args){
		int[] arr = {8, 6, 1, 2, 5, 4};
		MinHeap mh  = new MinHeap(arr.length);
		for (int num: arr)
			mh.insert(num);
		
		System.out.println(mh);
		
		mh.getMin();
		System.out.println();
		System.out.println(mh);
		

	}
}