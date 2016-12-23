An animal shelter, which holds only dogs and cats, operates on a strictly"fi rst in, fi rst 
out" basis. People must adopt either the "oldest" (based on arrival time) of all animals at the shelter, 
or they can select whether they would prefer a dog or a cat (and will receive the oldest animal of 
that type). They cannot select which specifi c animal they would like. Create the data structures to 
maintain this system and implement operations such as enqueue, dequeueAny, dequeueDog, 
and dequeueCat. You may use the built-in Linked list data structure. 


animal Shelter problem from CTCIhttp://codereview.stackexchange.com/questions/144312/animal-shelter-in-java
http://massivetechinterview.blogspot.com/2015/07/cc150v5-37-stack-of-animals.html

We can use the same queue for both dogs and cats. If we do so and the user wants a dog, we will have to search through the queue to get the first dog. So we will use separate queues for dogs and cats
We will also add a timestamp for each animal, so that when the user wants any animal, they will get the oldest animal.

Cat and Dog inherits from animal because
dequeAny() should support returning of dog or cat objects.

abstract class Animal {
		private int timeStamp;
		public String name;
		public Animal(String name){
			this.name = name;
		}
		public void setTime(int time){
			this.timeStamp = time;
		}
		public int getTime(){
			return this.timeStamp;
		}
		
		public void setTime(int time){
			this.timeStamp = time;
		}
		
		public boolean isOlderThan(Animal a){
			return this.timeStamp < a.getTime();
		}
}

public class Dog extends Animal{
	public Dog(String name){
		super(name);
	}
}

public class Cat extends Animal{
	public Cat(String name){
		super(name);
	}
}

class AnimalQueue{
	Queue<Dog> dogQueue = new LinkedList<>();
	Queue<Cat> catQueue = new LinkedList<>();
	private int timeStamp = 0;
	
	public void enqueue(Animal animal){
		animal.setTime(timeStamp);
		timeStamp++;
		
		if (animal instanceOf Dog)
			dogQueue.offer((Dog)animal);
		else if (animal instanceOf Cat)
			catQueue.offer((Cat)animal);
			
	}
	
	// Compare the timestamp of oldest dog and oldest cat and return the oldest amongst them. Oldest cat and oldest dog will be at the front of the respective queue
	public Animal dequeueAny(){
		if (dogQueue.size() == 0)
			dequeuCat();
		if (catQueue.size() == 0)
			dequeuDog();
		
		if (dogQueue.peek().isOlderThan(catQueue.peek()))
			dequeueDog();
		else
			dequeuCat();
	}
	
	public Dog dequeuDog(){
		if (dogQueue.size() == 0)
			throw new NoDogsException();
		return dogQueue.poll();
	}
	
	public Cate dequeuCat(){
		if (catQueue.size() == 0)
			throw new NoCatsException();
		return catQueue.poll();
	}
}