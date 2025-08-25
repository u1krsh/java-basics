import java.util.Scanner;
public class odd_even {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int x = 1;

        while(x==1) {
            System.out.println("Enter A number: ");
            int num = scn.nextInt();
            if (num > 0) {
                if (num % 2 == 0) {
                    System.out.println("The number is EVEN");
                } else {
                    System.out.println("The number is ODD");
                }
            } else {
                System.out.println("Invalid Number");
            }
            System.out.println("Do you want to check again?(1-yes,0-no)");
            int inp = scn.nextInt();
            if (inp == 1 || inp ==0){
                x = inp;
            }
            else{
                System.out.println("Either 0 or 1");
                break;
            }
        }
    }
}
