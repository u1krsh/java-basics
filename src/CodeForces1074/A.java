package CodeForces1074;
import java.util.*;
import java.io.*;
public class A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            for (int i = 1; i <= n; i++) {
                sb.append(i * i);
                if (i < n) sb.append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}
