import java.util.Scanner;
public class usr_inp_arr {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter Number of elements: ");
        int x = scn.nextInt();
        scn.nextLine(); // Add this line to consume the leftover newline

        String[] arr = new String[x];

        for(int i = 0; i < x; i++){
            System.out.print("Enter element: ");
            String y = scn.nextLine();
            arr[i] = y;
        }

        System.out.println("\nYour elements are:");
        for(String s: arr){
            System.out.println(s);
        }

        scn.close(); // Good practice to close the scanner when done
    }
}