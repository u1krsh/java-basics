import java.util.Scanner;

public class scanner {

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = scn.nextLine();

        System.out.println(name+" what is your age?");
        int age = scn.nextInt();
        System.out.println(name+" what is your gpa?");
        double gpa = scn.nextDouble();

        System.out.println(name+" is "+age+" years old and has a gpa "+gpa);

        scn.close();
    }
}
