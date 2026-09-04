package CodeForcesVIrtual67;

import java.io.*;
import java.util.*;

public class C {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());

            for (int i = 0; i < n; i++) {
                int small = i + 1;
                int median = n + 1 + 2 * i;
                int large = n + 2 + 2 * i;

                sb.append(small).append(' ').append(median).append(' ').append(large);
                if (i < n - 1) sb.append(' ');
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }
}