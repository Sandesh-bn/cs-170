// consider using static factory method instead of constructors
// not required to create a new object
public static Boolean getBoolean(boolean b){
	return b? Boolean.TRUE: Boolean.FALSE;
}

// most secure way to define singleton
public class Elvis{
	private static final Elvis INSTANCE = new Elvis();
	private Elvis(){}
	public static Elvis getInstance(){
		return INSTANCE;
	}
}

// to make this object serializable, it is not sufficent to add 
//'implement Serializable',. you have to declare all instance fields as 
//transient and provide readResolve method
private Object readResolve(){
	return INSTANCE;
}

// the best way although not widely used way to create
// singleton  is to use Enum
public enum Elvis{
	INSTANCE;
	// other methods
}


// use of private constructors
// it can be used to make class non instantiable
// using Abstract class does not work. since you can inherit it and the
// subclass can be instantiated
// use private constructors instead
// it can never be subclassed since to create 
// subclasses super class constructor has to be called

public class UtiliyClass{
	private UtiliyClass(){
		throw new AssertionError();
	}
}


// reusing existing objects is better than creating new objects.
// objects can alwayw be reused if it is immutable

String s = new String("some string"); // BAD, creates a new string object
// if above code exists inside for loop, it will create millions of objects

String s = "good string"; // use existing string. Preferred
// this is highly recommended especially if the class is 
// made of sevveral instance vaariables

// always prefer primitives, instead of boxed primitives
// don't think that creating object cretion is expenxive.


// avoid finalize as much as possible
// executing finalize can take arbitrarily long time.
// dont put time-critical code inside finalize
// dont depend on finalizer to update critical persistent state.
// it takes nearly 400 times to create object with finalizer than without
// instead of using finalizer to terminate resources such as files and threads,
// use a custom method instead.


// obey general contract when overrriding equals
// avoid overrding equals if
	// each instance of the class is inherently unqiue
	// superclass has already overriden equals and it has an appropriate implementation


// equals contract
// for any non-null reference x.equals(x) is true
// x.equals(y) returns true only if y.equals(x) is true
// if x.equals(y) is true, y.equals(z) is true, x.equals(z) must true
// multiple invocation of x.equals(y) must return consistent value
// x.equals(null) must always return false. x is non-null


// recipe for equals
// test if == is true, if yes, return true.
// use instanceof to check if its correctt type. if it is not, return false. you should compare it to some iterface/class.
// cast the argument to correct type
// for each field in the class check their equality.
	// for float and double use Float.compare Double.compare
	// for primitive use ==
	// for objects recursively call equals
// ask yourself is it symmetric? is it transitive? is it consistent?

// always override hashcode if you override equals

// don't do this
public boolean equals(MYClass o){
	//BADD... CODE
}
// above code does not override Object.equals but overloads it instead.
public boolean equals(Object o){
	//REcommended code
}

class PhoneNumber{

	@override
	public boolean equals(Object o){
		if (o == this) return true;
		if (!(o instanceof PhoneNumber))
			return false;
		PhoneNumber other = (PhoneNumber)o;
		return this.lineNumber = other.lineNumber &&
			   this.name.equals(other.name);
	}
}


// YOU MUST OVERRIDE hashcode WHENEVER YOU OVERRIDE equals
// contract
// hashcode should consistently return the same integer 
// if two objects are equal according to Object.equals they must return same integer
// if two objects are uneual by Object.equals hashcode may or may not return idfferent ingegers.
// if it returns different integer, it improves performance of hashtables

// there is an hashcode recipe in joshua block book. use that.
// during an itnerview, say that there is a recipe in effective java
// and I haven't memorized it.

// if hashcode is not impellmented properly
// it might end up mapping instances to very few hash codes
// and this will result in large number of instances to few buckets
// and causes quadratic performance

// always override sostring

// it should produce consise and informative representation that is easy to read.


// consider implementing Comparable
// it is easy to search values
// it is easy to get extreme values
// we can implement automatic sorting
// rules
	// if x.compareTo(y) == -y.compareTo(z)
	// if x.compareTo(y) > 0 && y.compareTo(z) > 0, then x.compareTo(x) is > 0
	// if x.compareTo(y) == 0, then x.compareTo(z) == y.compareTo(z) for all z

//public classes should never have public fields

//make every field final unless there is compelling reason not to do so.
// limit the mutability of fields


// use enums instead of int constants. they offer more features.

// associate values with each constant
public enum Ensemble {
	SOLO(1), DUET(2), TRIO(3), QUARTET(4), QUINTET(5),
	SEXTET(6), SEPTET(7), OCTET(8), DOUBLE_QUARTET(8),
	NONET(9), DECTET(10), TRIPLE_QUARTET(12);
	private final int numberOfMusicians;
	Ensemble(int size) { this.numberOfMusicians = size; }
	public int numberOfMusicians() { return numberOfMusicians; }
}

// return empty collections instead of null.

// avoid using double floatss for monetary calculations.

// do not use == on boxed primitives.
// unbox it and assign it to primitives and then you can use ==

// native methods
// can perform comuputation in native languages such as C or C++
// they provide access to platform-spciific faciliites like registries, file locks.
// they provide access to legacy code and legacy data.
// they are not platform independednt and hence code is not portable.
// are not immune to memory corruption errors.
// use as little native methods as possible.

// use checked exceptions for recoverable errors and runtime exception for programmer error
// always document the precise exception, a method throws.
// don't write @throws Exception or @throws Throwable.

// do not have an empty catch block.


// null reference
// Student s1 = nulls1 is not pointing to any object


GARBAGE collections

if object has no reference to it, it is eligible for gc
setting reference to null
Student s1 = new Student();
s1 = null;

re-assigning reference variable also makes old object eligible for gc
Student s1 = new Student();
Student s2 = new Student();

s1 = new Student(); // causes old object to be eligib for gc

when you call new, objects will be allocated in "heap"
GARBAGE collector is a deamon thread called "garbage collector"

by forcing System.gc(), you cannot force gc to happen

garbage collections
it involves 3 steps
1) Mark: Starts from root node(main), walks the object graph, marks objects that are
reachable as live.
2) Sweep: Deletes unreachablee objects
3) Compacting: moves around objects to make allocation contigous than fragmented.

