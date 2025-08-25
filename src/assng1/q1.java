package assng1;
import java.util.Scanner;
public class q1 {
    public static void main(String[] args){
      Scanner scn = new Scanner(System.in);

        System.out.print("Enter First number: ");
        int a = scn.nextInt();
        System.out.print("Enter First number: ");
        int b = scn.nextInt();
        System.out.print("Enter First number: ");
        int c = scn.nextInt();

        if(a>b && a>c){
            System.out.println(a);
        }
        else if(b>c){
            System.out.println(b);
        }
        else{
            System.out.println(c);
        }
    }
}
