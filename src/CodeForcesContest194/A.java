package CodeForcesContest194;
import java.util.*;
import java.io.*;
import java.util.StringTokenizer;
public class A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[] a = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) a[i] = Integer.parseInt(st.nextToken());

            int need = (a[0] == 1 ? 1 : 0) + (a[n - 1] == 1 ? 1 : 0);

            int availableZeros = 0;
            for (int i = 1; i < n - 1; i++) {
                if (a[i] == 0) availableZeros++;
            }

            if (need <= availableZeros) {
                sb.append(need).append('\n');
            } else {
                sb.append(-1).append('\n');
            }
        }
        System.out.print(sb);
    }
}
