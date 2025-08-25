class Car{
    String model;
    String color;

    Car(String model,String color){
        this.model = model;
        this.color = color;
    }
    void drive(){
        System.out.printf("You drive the %s of %s color\n",model,color);
    }
}

public class arr_of_obj {
    public static void main(String[] args){
        Car car1 = new Car("Mustang","Red");
        Car car2 = new Car("Honda","Black");
        Car car3 = new Car("Suzuki","White");

        Car[] cars = {car1,car2,car3};

        for(Car i:cars){
           i.drive();
        }

    }
}
