import java.util.Scanner;
public class number_guess_while {
    public static void main(String[] main){
        int number = 69;
        int num = 1;
        Scanner scn = new Scanner(System.in);
        while(number != num && num<=100 ){
            System.out.print("Enter value between 1-100: ");
            num = scn.nextInt();
            if(num > number){
                System.out.println("TOO HIGH NIGGA");
            }
            else if (num < number) {
                System.out.println("TOO LOW NIGGA");
            }
            else if(num == number){
                System.out.println("YOU GUESSED IT RIGHT NIGGA");
            }
            else{
                System.out.println("DK WHAT YOU DID NIGGA");
            }
        }
    }
}
