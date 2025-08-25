package assng1;
import java.util.Arrays;
public class q5 {
    public static void main(String[] args){
        int[] arr = {5,30,22,4,2,10};
        Arrays.sort(arr);
        System.out.println("Sorted Array: ");
        for(int i : arr){
            System.out.print(i+",");
        }
    }
}
