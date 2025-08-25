import java.util.Scanner;
public class pythagoras {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);

        System.out.println("Enter Base: ");
        double base = scn.nextDouble();
        System.out.println("Enter Height: ");
        double height=scn.nextDouble();
        double hypo = Math.sqrt(Math.pow(base,2)+Math.pow(height,2));
        System.out.println("The hypotenuse is: "+hypo);
    }
}
