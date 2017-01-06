singleton class
used when a class can allow to crete only one object.
eg: Runtime classs. 
For multiplre requirements we can only use a single object. Memory utilization will improve

We use private constructors to prevent creation of objects using new keyword.

we use a private class variable of type class and intialize it inside the class

then getinstance method to retrieve this object.


multiple calss to getinstance will use the same object

class Test{
    
    private Test(){}

    private Test onlyObject = new Test();

    public static Test getTest(){
        return this.onlyObject;
    }

}

class Main{
    public static void main(String[] args){


        #Test t1 = new Test(); /// WILL CAUSE AN ERROR

        Test t2 = Test.getTest();
        Test t3 = Test.getTest();
        Test t4 = Test.getTest();


        t2, t3, t4 all refer to same Test object.

    }
}