package assng1;
import java.util.Scanner;
public class q7 {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter Number: ");
        int n = scn.nextInt();
        int a = 0, b = 1;
        for (int i = 0; i< n; i++) {
            System.out.print(a + " ");
            int n3 = b + a;
            a = b;
            b = n3;
        }
    }
}

