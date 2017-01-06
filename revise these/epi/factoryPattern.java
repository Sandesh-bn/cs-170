/*
The Factory Method off ers an interface for creating an instance of a class, 
with its subclasses deciding 
which class to instantiate. You might want to implement this with the creator class being abstract and not 
providing an implementation fo r the Factory method. 
Or, you could have the Creator class be a concrete 
class that provides an implementation for the Factory method. 
In this case, the Factory method would take 
a parameter representing which class to instantiate. 
*/

Factory pattern is used to create objects without exposing the creation logic

public interface Vehicle{
    getName();
    getColor();
}

public class Bike implements Vehcile{
    getName(){

    }

    getColor(){

    }
}

public class Car implements Vehcile{
    getName(){

    }
    getColor(){

    }
}

public class VehicleFactory{
    public Vehicle getVehicle(String type){
        if (type == null) return null;
        if (type.equals("Car")) return new car();
        if (type.equals("Bike")) return new Bike();
    }
}

class Main{
    public static void main(String[] args) {
        VehicleFactory vf = new VehicleFactory();

        Car c = vf.getCar("Car");
        Bike b = vf.getBike('Bike');
    }
}

