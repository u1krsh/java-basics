package assng1;
import java.util.Scanner;
public class q10 {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);

        System.out.println("Enter Number: ");
        int n= scn.nextInt();
        int sum = 0;
        for(int i =1;i<=n;i++){
            sum += i;
        }
        System.out.printf("Sum of first %d numbers is %d",n,sum);
    }

}
