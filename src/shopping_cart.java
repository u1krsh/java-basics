import java.util.Scanner;
public class shopping_cart {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);

        System.out.println("What would Like to buy?: ");
        String item = scn.nextLine();

        System.out.println("What is price of each item(Rupee): ");
        double price = scn.nextDouble();

        System.out.println("What Quantity you want: ");
        int quan = scn.nextInt();

        System.out.println(quan+" "+item+"s will cost you "+price*quan+" Rupees ");
        scn.close();
    }
}
