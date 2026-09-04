package CodeForcesVIrtual67;
import java.util.*;
public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n  = sc.nextInt();
        int[] x = new int[7];
        StringBuilder sb = new StringBuilder();

        for(int i =0; i< n;i++){
            long sum = 0;
            long max = Long.MIN_VALUE;
            for(int j = 0;j<7;j++){
                x[j] = sc.nextInt();
                sum += x[j];
                max = Math.max(x[j], max);
            }

            long ans = -sum + 2 * max;
            System.out.println(ans);
        }

    }
}
