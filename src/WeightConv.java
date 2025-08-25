import java.util.Scanner;
public class WeightConv {
    public static void main(String[] main) {
        Scanner scn = new Scanner(System.in);
        System.out.println("            --WEIGHT CONVERTER--");
        System.out.println("Choose option(Lbs to Kg)-1 (Kg to Lbs)-2: ");

        int option = scn.nextInt();
        if (option == 1) {
            System.out.println("Enter weight in Lbs");
            double lbs = scn.nextDouble();
            double ans = lbs/ 2.205;
            System.out.println(lbs + "lbs is " + ans + " kgs");

        }
        else if(option==2) {

            System.out.println("Enter weight in Kg");
            double kg = scn.nextDouble();
            double ans = kg * 2.205;
            System.out.println(kg + "kgs is " + ans + " lbs");
        }
        else{
            System.out.println("Invalid Choice");
        }
    }
}
