abstract class Vehicle{
    abstract void go();
}

class Car1 extends Vehicle{
    @Override
    void go(){
        System.out.println("You drive the car ");
    }
}

class Bike extends Vehicle{
    @Override
    void go(){
        System.out.println("You ride a bike");
    }
}
class Boat extends Vehicle{
    @Override
    void go(){
        System.out.println("You sail the boat");
    }
}

public class inherit {
    public static void main(String[] args){
        Car1 car = new Car1();
        Bike bike = new Bike();
        Boat boat = new Boat();
        
    }
}
