package CodeForcesContest1;
import java.util.*;
import java.io.*;
public class A {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        StringBuilder sb = new StringBuilder();

        in.nextToken();
        int t = (int) in.nval;

        while (t-- > 0) {
            in.nextToken();
            int n = (int) in.nval;

            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                in.nextToken();
                a[i] = (long) in.nval;
            }

            long ans;
            if (n == 1) {
                ans = a[0];
            } else {
                ans = gcd(a[0], a[n - 1]);
            }

            sb.append(ans).append("\n");
        }

        System.out.print(sb);
    }

    private static long gcd(long a, long b) {
        while (b != 0) {
            long tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }
}
