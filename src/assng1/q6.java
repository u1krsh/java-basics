package assng1;
import java.util.Scanner;
public class q6 {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        String a = scn.next();
        StringBuilder sb = new StringBuilder(a);
        sb.reverse();
        if(a.equals(sb.toString())){
            System.out.println("Pallindrome");
        }
        else {
            System.out.println("Not Pallindrome");
        }
    }
}
