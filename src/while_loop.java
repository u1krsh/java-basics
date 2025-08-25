import java.util.Scanner;
public class while_loop {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        String name = "";
        while(name.isEmpty()){
            System.out.print("Enter your name: ");
            name = scn.nextLine();
        }
        System.out.println("Hello "+name);
    }
}
