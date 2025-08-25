import java.util.Stack;

abstract class Shape{
    abstract double area();

    void display(){
        System.out.println("This is a shape");
    }
}
class Circle extends Shape{
    @Override
    double area() {
        return 0;
    }
}
class Triangle extends Shape{
    @Override
    double area(){
        return 0;
    }
}

public class abstract_mtd {
    public static void main(String[] args){
        Circle circle = new Circle();
        Triangle triangle = new Triangle();
    }
}
