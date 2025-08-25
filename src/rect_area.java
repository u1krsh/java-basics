import java.util.Scanner;
public class rect_area {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter Width: ");
        double width = scn.nextDouble();
        System.out.println("Enter Breadth: ");
        double breadth = scn.nextDouble();
        System.out.println("The area of rectangle: "+width*breadth );
    }
}
