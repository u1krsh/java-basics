import java.util.Scanner;
public class banker {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);

        int balance = 0;
        while(true){
            System.out.println("*********\n BANKER\n*********\n1. Show Balance\n2. Deposit\n3. Withdraw\n4. Exit\n*********");
            System.out.print("Enter Choice: ");
            int n = scn.nextInt();
            if(n == 1){
                System.out.println("YOUR CURRENT BALANCE IS " + balance);

            }
            else if (n==2) {
                System.out.print("ADD MONEY: ");
                int x = scn.nextInt();
                balance =+ x;
                System.out.println(x+ " Rupees Successfully added to your account");
            }
            else if (n==3) {
                System.out.print("ENTER AMOUNT TO WITHDRAW: ");
                int y  = scn.nextInt();
                balance -= y;
            }
            else if(n == 4){
                break;
            }
            else{
                System.out.println("Invalid Input");
            }
        }
    }
}
