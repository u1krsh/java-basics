import java.util.Scanner;
public class Sphere_circ {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter Option(1-Circle,2-Sphere): ");
        int x = scn.nextInt();
        System.out.println("Enter Radius: ");
        double radius = scn.nextDouble();
        if (x == 1){
            double circum = 2 * Math.PI* radius;
            double area = Math.PI * Math.pow(radius,2);
            System.out.println("The circumference: "+ circum);
            System.out.println("The area: "+area);

        } else if (x==2) {
            double circum = 2 * Math.PI* radius;
            double area = 4 * Math.PI * Math.pow(radius,2);
            double vol = 1.33 * Math.PI * Math.pow(radius,3);
            System.out.println("The circumference: "+ circum);
            System.out.println("The area: "+area);
            System.out.println("The voulme: "+ vol);

        }

    }
}
