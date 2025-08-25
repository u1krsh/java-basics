package assng1;
import java.util.Scanner;
public class q3 {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter number: ");
        int n = scn.nextInt();
        int fac =1;
        for(int i =1;i<=n;i++) {
            fac = fac * i;
        }
        System.out.println(fac);
    }

}
