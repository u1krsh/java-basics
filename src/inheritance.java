class Organism{
    boolean isAlive;

    Organism(){
        isAlive = true;
    }
}

class Animal extends Organism{
    void eat(){
        System.out.println("The animal is eating");
    }
}

class Dog extends Animal{
    int lives = 1;
    void speak(){
        System.out.println("Woof");
    }
}

class Cat extends Animal{
    int lives = 9;
    void speak(){
        System.out.println("Meow");
    }
}

public class inheritance {
    public static void main(String[] args){
        Dog dog = new Dog();
        Cat cat = new Cat();
        System.out.println(dog.isAlive);
        System.out.println(cat.isAlive);
    }
}
