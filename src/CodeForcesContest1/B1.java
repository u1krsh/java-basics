package CodeForcesContest1;
import java.io.*;
import java.util.*;

public class B1 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        StringBuilder sb = new StringBuilder();

        in.nextToken();
        int t = (int) in.nval;

        while (t-- > 0) {
            in.nextToken();
            int n = (int) in.nval;
            in.nextToken();
            int m = (int) in.nval;

            int[] freq = new int[m + 2];
            for (int i = 0; i < n; i++) {
                in.nextToken();
                int v = (int) in.nval;
                freq[v]++;
            }

            int[] prefix = new int[m + 2];
            for (int v = 1; v <= m; v++) {
                prefix[v] = prefix[v - 1] + freq[v];
            }

            int best = 0;
            for (int x = 1; x <= m; x++) {
                int cntGreater = n - prefix[x];
                int twoX = (2 * x <= m) ? freq[2 * x] : 0;
                int val = freq[x] + cntGreater + twoX;
                if (val > best) best = val;
            }

            sb.append(best).append('\n');
        }

        System.out.print(sb);
    }
}
