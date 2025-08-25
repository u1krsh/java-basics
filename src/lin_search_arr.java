import java.util.Arrays;
public class lin_search_arr {
    public static void main(String[] args){
        int[] arr = {0,1,2,3,4,5,6,7,8};
        int tar = 9;
        boolean  isFound = false;
        for(int i = 0;i<arr.length;i++){
            if(tar==arr[i]){
                System.out.println("It exists");
                isFound = true;
                break;
            }
        }
        if(!isFound){
            System.out.println("Element not found");
        }
    }
}
