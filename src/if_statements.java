import java.util.Scanner;
public class if_statements {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);

        System.out.println("Enter Your Age: ");
        int age = scn.nextInt();

        if(age >= 18){
            System.out.println("You are an adult");
        }
        else if(age > 0){
            System.out.println("You are a child");
        }
        else{
            System.out.println("Invalid age");
        }
    }
}
