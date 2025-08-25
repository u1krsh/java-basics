package assng1;
import java.util.Scanner;
public class q4 {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);

        System.out.println("Enter first number: ");
        int a = scn.nextInt();

        System.out.println("Enter Second number: ");
        int b = scn.nextInt();

        System.out.printf("Sum: %d\n",a+b);
        System.out.printf("Difference: %d\n",a-b);
        System.out.printf("Product: %d\n",a*b);
        System.out.printf("Divide: %d\n",a/b);
    }
}
