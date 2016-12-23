public class Vector2d{
	int index = 0;
	List<Integer> result = new ArrayList<>();
	
	public Vector2d(List<List<Integer>> vector2d){
		for (List<Integer> list: vector2d)
			result.addAll(list);
	}
	
	public int next(){
		return result.get(index++);
	}
	public boolean hasNext(){
		return index < result.size();
	}
}