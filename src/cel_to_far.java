import java.util.Scanner;
public class cel_to_far {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.println("--TEMPERATURE CONVERT--");
        System.out.println("Enter the option(1-CEL TO FAR, 2-FAR TO CEL):");
        int option = scn.nextInt();
        if(option == 1){
            System.out.println("Enter temp in celsius: ");
            double cel = scn.nextDouble();
            double far = (cel * 9/5) + 32;
            System.out.printf("%.3f celsius is %.3f fahrenheit",cel,far);

        }
        else if(option == 2){
            System.out.println("Enter temp in fahrenheit: ");
            double far = scn.nextDouble();
            double cel =  (far- 32) * 5/9;
            System.out.printf("%.3f fahrenheit is %.3f celsius",far,cel);
        }
        else{
            System.out.println("Invalid Input");
        }
    }
}
