package assng1;
import java.util.Scanner;
public class q2 {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter number: ");
        int n = scn.nextInt();

        for(int i = 1;i<=10;i++){
            System.out.println(n+" * "+i+" = "+n*i);
        }

    }
}
