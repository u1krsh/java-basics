import java.util.Scanner;
public class dolla_matrix {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter Symbol: ");
        String sym = scn.nextLine();

        System.out.print("Enter number of rows: ");
        int row = scn.nextInt();

        System.out.print("Enter number of columns: ");
        int col = scn.nextInt();

        for(int i = 0; i < col;i++){
            for(int j = 0; j < row;j++){
                System.out.print(sym);
            }
            System.out.println();
        }
    }
}
