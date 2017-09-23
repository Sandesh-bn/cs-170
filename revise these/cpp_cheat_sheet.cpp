#include<iostream>
#include<vector>


// vector
// vector is dynamically allocated contiguous array
// fast insert removal at end O(1)
// slow insert in begin and end O(N)
// slow search O(n)
int main(){
    vector<int> vec;
    vec.push_back(4);
    vec.push_back(1);
    vec.push_back(8);
    cout << vec[2];   // no range check
    cout << vec.at(2); // throw exception

    for (int i; i < vec.size(); i++)
        cout << vec[i];
    
    // faster
    for (vector<int>::iterator it = vec.begin(); it != vec.end(); it++)
        cout << *it ;
    
    for (it: vec)   // C++
        cout << it << " ";

    // check if is empty
    if (vec.empty())
        cout << "Empty";
    
    cout << "size: " << vec.size();

    // copy constructor
    vector<int> copy(vec);

    // swap
    vec
}

// deque
fast insert in front end 
slow insert in removing


// list double end linked list
fast inert anywhere
no random access
slow search, much slower than vector due to data stored in random location.
list also consumes more memory than vector due to two pointers
slice is O(1) which is the biggest advantage.

int main(){
    list<int> mylist = {5, 2, 9};
    mylist.push_back(4);  // 5, 2, 9, 4
    mylist.push_front(1); // 1, 5, 2, 9, 4

    list<int>::iterator itr = find(mylist.begin(), mylist.end(), 2);
    //itr -> 2
    
    mylist.insert(itr, 8); // 1,5,8, 2, 9, 4


    itr++; // itr->9
    mylist.erase(itr) //1,5,8,2,4

}

// set
// no duplicates
// maintains sorted order.
// find() is O(log(n)) compared to O(n) for list, deque, vector
int main(){
    set<int> myset;
    myset.insert(3); // 3
    myset.insert(1); // 1, 3
    myset.insert(7); // 1, 3, 7
    // log(n) operation

    set<int>::iterator itr;
    itr = myset.find(7), it points to 7
}

// unordered containers are implemented using
// hashtable. ie array of linkedlist
// 
int main(){
    unordered_set<string> myset = {"red", "green", "blue"};
    unordered_set<string>::const_iterator itr = myset.find("green");

    if (itr != myset.end()) //IMPORTANT
        cout << *itr << endl;
    myset.insert("yellow");


    vector<string> vec = {"purple", "pink"};
    myset.insert(vec.begin(), vec.end());
    
    TODO//check if myset contains a copy of vec or vec is concatednated to 
    // myset

    cout << "load factor " << myset.load_factor() << endl;
    cout << "total bucket " << myset.bucket_count() << endl;
}

// unordered multiset: allows duplicates
// unordered map: hashmap
// unordered multimap : hashmp with duplicate keys
// hash collision leads to performance degradation
// unorderd containers
// fastest search and insertion
// update cannot be made for values
// 
int main(){
    unordered_map<char, string> day = {{'S', "Sunday"}, {'M', "MOnday"}};

    cout << day['S'] << endl;
    cout << day.at('S') << endl;

    day.insert(make_pair('F', "Friday"));
    day['T'] = "Thursday" ;


    // BEST WAY TO ACCESS MAP keys
    auto itr = m.find('S');
    if (itr != m.end())
        cout << *itr << endl; 
}

// if you are trying to access values using pointers
// in an vector / dequeu
// and suddenly you insert new value or remove exisiting value
// the pointers that you are previously using will become invalidated
//As std::vector is a dynamic data structure it provides the ability to resize itself. The internal buffer of vector is implemented as an array, which is stored in contiguous memory. When adding a new element to the vector, it may have to resize itself to accommodate this new element. In doing so it may have to completely relocate the internal array buffer to find some area of contiguous memory that is large enough. Thus rendering the old pointer invalid.


Iterators
vector<int> itr;
itr = itr + 5; // advance by 5 values
itr = itr - 4; // move back
if (itr2 > itr1)
++itr;  /// faster than itr++
--itr;

// list, set and map have bidirectional iterators
no comparision bw iterator
++itr;
--itr;

// forward iterator: forward_list
forward_list<int> list;
only ++itr;


//input iterator
// read values using iterator
int value = *itr;

// output iterator
// modify vlaue
*itr = 100

const_iterator allows read-only iteration thru the containerrs
int main(){

    set<int>::iterator itr;
    set<int>::const_iterator citr;
    
    set<int> myset = {2, 4, 5, 1, 9};
    for (citr = myset.begin(); citr != myset.end(); ++citr)
        cout << *citr << " ";
        // *citr = 8   won't commpile
        
    advance(itr, 5);  same as itr += 5;
    distance(itr1, itr2)   // distance bw itr1 itr2
}

// Algorithms
vector<int> vec = {4, 2, 5, 1, 3, 9};
vector<int>::iterator itr = min_element(vec.begin(), vec.end());

sort(vec.begin(), itr);

reverse(itr, vec.end());

vector<int> vec2(e);

copy(itr, vec.end(), vec2.begin());


vector<int> vec = {9, 60, 90, 8, 45, 87, 90, 69, 69, 55, 7};
    vector<int> vec2 = {9, 60, 70, 8, 45, 87};
    vector<int>::iterator itr, itr2;
    pair<vector<int>::iterator, vector<int>::iterator> pair_of_itr;
    
    // COUNT
    int num = count(vec.begin(), vec.end(), 69);
    cout << "69 occurs " << num << " times." << endl;;
    
    num = count(vec.begin(), vec.end() - 3, 69);
    cout << "excluding last 3 digits, 69 occurs " << num << " times.\n";
    
    // in the below ex we are using lambda function as 3rd argument
    num = count_if (vec.begin(), vec.end(), [](int x){return x < 10;});
    cout << "number of items less than 10 " << num << endl;
    
    
    // MIN MAX
    itr = max_element(vec.begin() + 2, vec.end());
    cout << "max element is " << *itr << "\n";
    
    // MAX using custom comparator, in below case, only based on last digit.
    itr = max_element(vec.begin(), vec.end(), [](int x, int y){
        return(x % 10)< (y % 10);
    });
     cout << "first max element based on lsb is " << *itr << ".\n";
    
    // Linear search
    itr = find(vec.begin(), vec.end(), 55);
    cout << "Returns first occurence based on comparator "<< *itr << "\n";
    
    itr = find_if(vec.begin(), vec.end(), [](int x){return x > 80;});
    cout << "the first number greater than 80 is " << *itr << "\n";
    
    // OPPOSITE OF ABOVE SEARCH
    itr = find_if_not(vec.begin(), vec.end(), [](int x){return x > 80;});
    cout << "the first number not greater than 80 is " << *itr << "\n";
    
    // TODO: SEARCH SUBRANGE
    // TODO: mismatch function
    vector<int> sub = {45, 87, 90};
    itr = search(vec.begin(), vec.end(), sub.begin(), sub.end());
    cout << "start of subrange " << *itr << "\n";
    
    itr = find_end(vec.begin(), vec.end(), sub.begin(), sub.end());
    cout << "end of subrang " << *itr << "\n";
    
    
    // given a subset, find first occurence of any number within subset in the vec
    vector<int> items = {87, 69};
    itr = find_first_of(vec.begin(), vec.end(), items.begin(), items.end());
    cout << "Given {87, 69}, the first occurence found is " << *itr << "\n";
    // we can pass lambdda function
    itr = find_first_of(vec.begin(), vec.end(), [](int x, int y){return x == y * 4;});
        
        // search_adjacent, return first element that occurs in pair
    itr = adjacent_find(vec.begin(), vec.end(), [](int x, int y){return x == y * 4;});   
    
    if (equal(vec.begin(), vec.end(), vec2.begin()))
        cout << "vec and vec2 are same.\n";
    
    if (is_permutation(vec.begin(), vec.end(), vec2.begin(), vec2.end()))
        cout << "vec and vec2 have same items, in different order.\n";
    
    lexicographical_compare(vec.begin(), vec.end(), vec2.begin(), vec2.end());
    // {1,2,3,5} < {1,2,4,5}
    // {1, 2} < {1, 2, 3}
    
    is_sorted(vec.begin(), vec.end());// check if item is sorted
    
    is_sorted_until(vec.begin(), vec.end()); // returns first item from which item is no lonber sorted.
    
    all_of(vec.begin(), vec.end(), [](int x){return x > 80;}); // tru if all elements are > 80
      
    any_of(''); // returns true, if atelast one element is > 80
    none_of(''); // returns true, if none of element is > 90


    // copy v into v2 and replace v2's content. make sure v2 has enough space

    
    vector<int> v = {9, 60, 70, 8, 45, 87, 90};
    vector<int> v2 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    copy(v.begin(), v.end(), v2.begin());
    for (int e: v2)
        cout << e << " ";
    cout << endl;
    
    
    v2 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    copy_if(v.begin(), v.end(), v2.begin(), [](int x){return x > 80;});
    for (int e: v2)
        cout << e << " ";
    cout << endl;
    
     v2 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    copy_n(v.begin(), 4, v2.begin()); // copy 4 elements from v to v2
    for (int e: v2)
        cout << e << " ";
    cout << endl;
    
    v2 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    copy_backward(v.begin(), v.end(), v2.end()); // v2.end nto v2.begin
    for (int e: v2)
        cout << e << " ";
    cout << endl;
    
    // transform
    v2 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    transform(v.begin(), v.end(), v2.begin(), [](int x){return x - 1;});
    for (int e: v2)
        cout << e << " ";
    cout << endl;
    
    v = {9, 60, 70, 8, 45, 87, 90};
    v2 = {9, 60, 70, 8, 45, 87, 90};
    vector<int> v3 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    transform(v.begin(), v.end(),
              v2.begin(),
              v3.begin(),
             [](int x, int y){ return x + y; });
    // v3[0] = v[0] + v2[0]
    for (int e: v3)
        cout << e << " ";
    cout << endl;
    
    // FILL
     v = {0, 0, 0, 0, 0};
    fill(v.begin(), v.end(), 9);
    for (int e: v)
        cout << e << " ";
    cout << endl;
    
    // FILL_N : fill first n
     v = {0, 0, 0, 0, 0};
    fill_n(v.begin(), 3, 9);
    for (int e: v)
        cout << e << " ";
    cout << endl;
    
    // replace all 6 with 9
    replace(v.begin(), v.end(), 6, 9);
    
    // replace if
    replace_if(v.begin(), v.end(), [](int x){return x > 90;}, 9);
    
    // remove all 3
    remove(v.begin(), v.end(), 3);
    
    // remove all items > 90
    remove(v.begin(), v.end(), [](int x){return x > 90;});
    
    // copy all non-3 items from v to v2
    remove_copy(v.begin(), v.end(), v2.begin(), 3);
    
    // reverse
    reverse(v.begin() + 1, v.end() - 1);// reverse in range 1 - N - 2;
    
    // reverse copy
    reverse_copy(v.begin() + 1, v.end() - 1, v2.begin());


// you cannot returnan entire array instead you can return the pointer to the first element of the array
// also you should make teh array static instea of a local variable
int* myfunction(){
    static int r[10];
    for (int i = 0; i < 10; i++)
        r[i] = i;


    return r;

}

int main(){
    int *p = myfunction();
    for (int i = 0; i < 10; i++)
        cout << *(p + i) << " ";
}

// you cannot pass an entire array as argument, instead
// you pass teh address of starting number
void myfunction(int *arr){

}
void myfunction(int arr[10]){

}
void myfunction(int arr[]){

}

double getAvg(int arr[], int size){
    double sum = 0.0;
    for (int a: arr)
        sum += a;
    return sum / size;
}

int main(){
    int arr[] = {5, 2, 3, 1 , 7};
    cout << getAvg(arr, 5);

}


REFERENCE VS pointers
    no Null reference. Reference is always connected to legit storage
    reference cannot be changed. pointers can be made to point to another variable
    reference must be intialized

int main(){
    int i  = 10;
    double d = 10.0;
    int& r = i;
    double& s = d;

    i = 5;
    cout << "Value of i " << i << endl;
    cout << "value of i using reference " << r << endl;

    cout << "Address of i " << &i << endl;
    cout << "Address of i using reference " << &r << endl;
}

// every object in c++ has access to its own 
// address thru pointer called this pointer.

class Box{
    private:
        double length;
        double breadth;
    public:
    Box(double l = 2.0, double h = 2.0){
        length = l;
        height = h;
    }

    double Area(){
        return length  * height;
    }

    int compare(Box box){
        return this->Area() > box.Area();
    }
}
int main(){
    Box b(3.3, 2.2);
    Box b2(5, 6);

    if (b.compare(b2))
        cout << "Box1 is larger";
    else
        cout << "Box2 is larger"
}





We hardly use protected or private inheritance, but public inheritance is commonly used. While using different type of inheritance, following rules are applied:

Public Inheritance: When deriving a class from a public base class, public members of the base class become public members of the derived class and protected members of the base class become protected members of the derived class. A base class's private members are never accessible directly from a derived class, but can be accessed through calls to the public and protected members of the base class.

Protected Inheritance: When deriving from a protected base class, public and protected members of the base class become protected members of the derived class.

Private Inheritance: When deriving from a private base class, public and protected members of the base class become private members of the derived class.



// multiple inheritance

class Shape{
    protected:
        int width;
        int height;
    public:
    void setWidth(int w){
        width = w;
    }
    void setHeight(int h){
        height = h;
    }
}
class PaintCost{
    public:
        int getCost(int a){
            return a * 70;
        }
}

class Rectangle: public Shape, public PaintCost{
    public:
        int getArea(){
            return width * height;
        }
}

int main(){
    Rectangle r;
    
    r.setWidth(75);
    r.setHeight(15);
    cout << "Area = " << r.getAvg() << endl;
    cout << "paint cost is $" << r.getCost() << endl;
}


OPERATOR OVERLOADING

class Box{
    private:
        int width, height;

    public:
        double getArea(){
            return width * height;
        }
        void setHeight(int h){
            height = h;
        }
        void setWidth(int w){
            width = w;
        }
        Box operator+(const Box& b){
            Box box;
            box.width = this->width + b.width;
            box.height = this->height + b.height;
            return box;
        }
}

int main(){
    Box b1;
    Box b2;
    b1.setWidth(5);
    b1.setHeight(10);

    b2.setHeight(25);
    b2.setWidth(34);

    Box b3 = b1 + b2;
}



polymorphism
call to a member function will cause different function
to be executed depending on type of object that invokes it.

class Shape{
    protected:
        int width, heigth;
    public:
        Shape(int a = 0, int b = 0){
            width = a;
            height = b;
        }
        virtual int area(){
            return 0;
        }
}

class Rectangle: public Shape{
    public:
        Rectangle(int a = 0, int b = 0):Shape(a, b){

        }
        int area(){
            return width * height;
        }
}

class Triangle: public Shape{
    public:
        Triangle(int a = 0, int b = 0):Shape(a, b){

        }
        int area(){
            return width * height/2;
        }
}

int main(){
    Shape *s;
    Rectangle rec(10, 7);
    Triangle tri(8, 5);

    s = &rec;
    s->area(); // calls rectangle area

    s = &tri;
    s->area(); // calls triangle area;
}

// if you dont'' make parent class int area() as virtual 
then both calls of s->area() will end up calling shape class area()


A virtual function is a function in a base class that is declared using the keyword virtual. Defining in a base class a virtual function, with another version in a derived class, signals to the compiler that we don't want static linkage for this function.

What we do want is the selection of the function to be called at any given point in the program to be based on the kind of object for which it is called

Pure Virtual Functions
It's possible that you'd want to include a virtual function in a base class so that it may be redefined in a derived class to suit the objects of that class, but that there is no meaningful definition you could give for the function in the base class.

We can change the virtual function area() in the base class to the following:

class Shape {
   protected:
      int width, height;
   public:
      Shape( int a = 0, int b = 0) {
         width = a;
         height = b;
      }
		
      // pure virtual function
      virtual int area() = 0;
};
The = 0 tells the compiler that the function has no body and above virtual function will be called pure virtual function.


INTERFACES
interface describe the behavior for a c++ class without providing actual
implemnetation.

C++ interfaces are implemented using abstract classes.
Class can be made abstract by declaring atelast one of 
the function as pure virtual function
class Shape {
    protected:
        double width, height;

    public:
        virtual double getArea() = 0;

        void setWidth(int w){
            width = w;
        }
        void setHeight(int h){
            height = h;
        }
}

class Rectangle: public Shape{
    public:
        int getArea(){
            return width * height;
        }
}

class Triangle: public Shape{
    public:
        int getArea(){
            return width * height / 2;
        }
}
purpose of abstract class is to provide appropriate base class
from which base class can inherit from.
we cannot instantiate an abstract class.

when base class inherites an abstract class, it must
provide implementation for pure virtual function.


stack: all variable declared inside a function are allocated on stack.
heap: unused memory can be allocated using heap
use new to allocate memory in heap

data-type *ptr = new data-type

sometimes memory cannot be allocated. we must always check for this condition
double *pval = NULL;
pval = new double;

if (!(pval == new double)){
    cout << "no free memory" << endl;
    exit(1);
}

primary diff bw new and malloc() is that new also
creates an object.


char* cptr = NULL;
cptr = new char[20];

for (int i = 0; i < 20; i++)
    cptr[i] = i;

delete [] cptr;


namespace allows us to logically group classes, variables functions and it defines a scope


#include ...

namespace first_space{
    void func(){
        cout << "inside first";
    }
}

namespace second_space{
    void func(){
        cout << "inside second";
    }
}

int main(){
    first_space::func();

    second_space::func();

    return 0;
}


preprocessor directive: 
preprocessing occurs before compilation
it will expand all lines that begin with #
main.i is preproeccessed file of main.cpp
all lines that begin with # are preprocessed
we can also define macros

macros: 
#define MAX(a, b) ((a>b)? a:b)

int main(){
    double dx = 1.6;
    double dy = 2.1;
    double dMax = MAX(dx, dy);
    return 0;
}

fundamental types: boolean character Integer float/double void

destructor: never use exit() inside destructor. exit() calls destructor so this will lead to infinite recursion

class Name{
    const char* s;

}
class Table{
    Name* nptr;
    size_t sz;
    public: 
        Table(size_t s = 15){p = new Name[sz=s];}//Inline constructor

        ~Table(){delete [] p;} // destructor
        Name *search(const char*);
        bool insert(Name *)
}

enum is user defined data type with fixed set of values

enum SampleNum{ZERO, ONE, TWO, NINE=9, TEN}; // TEN will be 10

int main(){
    cout << fun((SampleNum) 2);
}

int fun(SampleNum val){
    int ret = 0;
    switch(val){
        case ZERO:
            ret = ZERO;
            cout << "ZERO";
            break;
        .. and so on.
    }
    return ret;
}


try-catch exception
int main(){
    char *buf;
    try{
        buf = new char[512];
        if (buf == 0)
            throw "Memory allocation fail";
    }
    catch(char *str){
        cout << "Exception raised " << str;
    }
}


TYPEDEF give an alias for existing type
typedef char * PCHAR;
typedef unsigned long ULONG;


friend functions give access to function to access private and protected members.


difference bw class and struct
we can implement inheritance with classes
we can implement access control for the data members and 
member functions of a class.

difference between deep and shallow copy
shallow copy 

shallow copy does not copy the actual data the
pointers and references point to. instead it just makes a copy
of pointer values

deep copying clones the underlying data as well.



class Mother{
    public:
    	Mother(){cout << "mother:noparam\n";}
    	Mother(int m) {cout << "mother, int param\n";}
};

class Daughter: public Mother{
    public:
    	Daughter(){cout << "daughter: no param\n";} // calss Mother no arg
    	Daughter(int a) {cout << "daughter: int param\n";} // calls Mother no arg. IMPORTANT
};

class Son: public Mother{
    public:
    	Son(){cout << "son no param\n";} // calls Mother no arg
    	Son(int a):Mother(a){ // Calls Mother int arg IMPORTANT
         	cout << "son int param\n";}
};

int main(){
    Daughter d;
    Daughter d2(5);
    Son s;
    Son s2(20);
}

mother:noparam
daughter: no param
mother:noparam
daughter: int param
mother:noparam
son no param
mother, int param
son int param

static cast: there are no runtime checks so you are on your own

void f(){
    char ch;
    int i = 65;
    float f = 2.5;
    double dbl;
    ch = static_cast<char>(i);
    dbl = static_cast<double>(f);
    i = static_cast<int>(ch); 
}

pointer cast
class B{}
class D: public B{}
void f(B *pb, D* pd){
    D* pd2 = static_cast<D*>(pb); // not safe, but C++ allows it.

    B* pb2 = static_cast<B*>(pd); // safe
}

dynamic test: performs runtime check
class B{};
class C: public B{};
class D: public C{};

void f(D *pd){
    C *ptrC = dynamic_cast<C*>(pd); // safe

    B *ptrB = dynamic_cast<B*>(pd); // safe

    // void pointers
    B* pB = new B;
    C* pC = new C;
    void *pv = dynamic_cast<void*>(pB);
    pv = dynamic_cast<void*>(pC);

    
}

dynamic_ast

class B{}
class D: public B{}

void f(){
    B* pb = new D;
    B* pb2 = new B;
    D* pd = dynamic_cast<D*>(pb); // safe ok, since pb points to  D
    D* pd2 = dynamic_cast<D*>(pb2); // error
}

template function functions that can operate on various valid types
template <class T>
T getMax(T a, T b){
    return a > b? a: b;
}

int main(){
    char a = 'A', b = 'B';
    int i = 5, j = 6;
    long l = 10, m = 5;
    cout << getMax(a, b) << endl;
    cout << getMax(i, j) << endl;
    cout << getMax(l, m) << endl;
}

class Templates
allow a class to accept different types as input 
tempalate<class T>
class mypair {
    T a, b;
    public:
    mypair(T first, T second){
        a = first;
        b = second;
    }
    T getMax();
}

template<class T>   // Must redefine this here.
T mypair<T>::getMax(){
    return a > b? a: b;
}
int main(){
    mypair<int> obj(100, 75);
    cout << obj.getMax() << endl;
    return 0;
}


Standard library containers

dynamic array = vector, 
associative array = map
Queue = queue, Heap = priority queue
Stack = stacks
LinkedList = list 
Trees = set

Vector 
resizable array
front() first elemetn
back() last element
push_back() append to end
pop_back() remove from the end
size 

list
double linked list


iterator are file pointers.
int main(){
    string str("Test string");
    string::iterator it;

    for (it = str.begin(); it < str.end(); it++)
        cout << *it;
}

non-virtual functions in classes are linked at compile time. static linking.

virtual functions are linked at run-time allowing derived classes to proived 
their own functionality. dynamic linking.


// references
void main()[
    int i = 100;
    int& ri = i;
    cout << i << endl;
    ri++; // when you increment reference, you increment the underlying value
    cout << i << endl;
]

exceptions

struct DemoError{};

int main(){
    try{
        throw DemoError();
    }
    
    catch(DemoError){

    }
    catch(exception& e){
        cout << "catchall exceptions. " << e.what() << endl; // similar to e.message
    }
    catch(...){
        cout << "something else happened.\n";
    }

    cout << "now leaing the message\n";

}


void MyFunction() throw(); // indicate to compiler that MyFunction() will not throw an error

void MyFunction() throw (MyError); // indicate to compiler that MyFunction() will throw MyError


inheritance
class Employee{
    private:
        string name;
        double pay;
    public:
        Employee(){
            name = "";
            pay = 0.0;
        }
        Employee(string n, double p){
            name = n;
            pay = p;
        }
        string getName() const{
            return name;
        }
        double getPay() const{
            return pay;
        }
        void setPay(double p){
            pay = p;
        }
        void setName(string n){
            name = n;
        }
        string toString(){
            stringsream st;
            stm << name << ": " << pay;
            return stm.str();
        }
}

class Manager: public Employee{
    private:
        bool salaried;
    public:
        // default constructor will automatically call base class constructor
        Manager() :salaried(true){}
        Manager(string name, double payRate, bool isSalaried)
            :Employee(name, payRate){
                salaried = isSalaried;
            }
        bool getSalaried(){
            return salaried;
        }
}

class Account{
    protected:
        double balance;
    public:
        Account(double b){
            balance = (bal > 0)?bal: 0;
        }
        void credit(double a){
            balance += a;
        }
        void debit(double a){
            if (balance < a)
                cout << "not enough funds\n";
            else
            balance -= a;
        }
        double getBalance() const{return balance;}
}
class CheckingAccount :public Account{
    private:
        double fee;
    public:
        CheckingAccount(double b, double f): Account(b){fee = f;}

        void debit(double a){
            if (balance > a)
                balance -= (amount + fee);
            else
                cout << "insufficient funds\n";
        }
}

abstract class: only purpose is to act as base class aand have other class inherit it.
we cannot instantiate an abstract class
pure virtual function a virtual function that has been intialized to 0.
class Shape{
    virtual void setX(int x) = 0;
    virtual void setY(int y) = 0;
    virtual void getX() const = 0;
    virtual void getY() const = 0;
    virtual void draw() const = 0;
}
class Circle: public Shape{
    private:
        int x, y, radius;
    public:
        Cirlce(int x, int y, int r){
            this.x = x;this.y = y;this.z = z;
        }
        virtual void setX(int x){
            this.x = x;
        }
        .. other setters
}


generic programming: perform certain tasks without specifying type and have the compiler determine the type at runtime.

template <typename T>
void display(T arr[], int size){
    for (int i = 0; i < size; i++)
        cout << arr[i] << " " ;
}

T max(T a, T b){
    return a > b ? a: b;
}

template stack

template<typename T>
class Stack{
    private: 
        T data[100];
        int top;
    public:
        Stack(){
            top = -1;
        }
        void push(T num){
            data[++top] = num;
            
        }
        T pop(){
            T val = data[top];
            data[top] = 0; // This class will not work when T is string
            --top;
            return val;
        }
        T peek(){
            return data[top];
        }
}

we have to provide template speciliaziation. it is used when we are providing a template
class for a specific class.
template<>
class Stack<String>{
    ....same as above except you replace T with string
}
int main(){
    Stack<int> nums;
    nums.push(2);
    nums.push(5);
    ....
}


exception handling: allows us to prevent program from crashing by handle exceptional cases 
