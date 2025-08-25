import java.util.Scanner;
public class substr {

    public static void main(String[] args){
        String email = "message.utkarshsingh@gmail.com";
        Scanner scn = new Scanner(System.in);
        String user = email.substring(8,20);
        System.out.println("Username: "+ user);

        String dom = email.substring(21,30);

        System.out.println("Domain: "+ dom);
    }
}
