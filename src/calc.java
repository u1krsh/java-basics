import java.util.Scanner;
public class calc {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter First Number: ");
        double num_1 = scn.nextDouble();

        System.out.println("Enter Operator(+,-,*,/,^):  ");
        String oper = scn.next();

        System.out.println("Enter Second Number: ");
        double num_2 = scn.nextDouble();

        switch (oper){
            case "+" -> System.out.println("Sum: "+ (num_1+num_2));
            case "-" -> System.out.println("Diff: "+ (num_1-num_2));
            case "*" -> System.out.println("Mul: "+ (num_1*num_2));
            case "/" -> System.out.println("Div: "+ (num_1/num_2));
            case "^" -> System.out.println("Pow: "+ (Math.pow(num_1,num_2)));
            default -> System.out.println("Invalid Input");
        }
    }
}
