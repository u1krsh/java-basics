package CodeForcesContest2;
import java.util.*;
import java.io.*;
public class G {
    public static void main(String[] args) throws IOException {
        DataInputStream in = new DataInputStream(new BufferedInputStream(System.in, 1 << 16));
        int t = nextInt(in);
        StringBuilder sb = new StringBuilder();
        final long MOD = 676767677L;

        while (t-- > 0) {
            int n = nextInt(in);
            int m = nextInt(in);
            int[] b = new int[n];
            for (int i = 0; i < n; i++) b[i] = nextInt(in);

            int[] freq = new int[m];
            for (int i = 0; i < n; i++) freq[b[i]]++;

            long[] prefixLE = new long[m];
            prefixLE[0] = freq[0];
            for (int v = 1; v < m; v++) prefixLE[v] = prefixLE[v - 1] + freq[v];

            long product = 1L;

            for (int i = 0; i < n; i++) {
                int bi = b[i];
                int t2;
                if (n == 1) {
                    t2 = 0;
                } else if (i == 0) {
                    t2 = b[1] + 1;
                } else if (i == n - 1) {
                    t2 = b[n - 2] + 1;
                } else {
                    t2 = Math.min(b[i - 1], b[i + 1]) + 1;
                }

                long ansI = 0;
                if (bi == 0) ansI += 1;

                if (bi >= 1) {
                    if (t2 < bi) {
                        ansI += freq[bi - 1];
                    } else if (t2 == bi) {
                        ansI += prefixLE[bi - 1];
                    }
                }

                ansI %= MOD;
                product = (product * ansI) % MOD;
            }

            sb.append(product).append('\n');
        }

        System.out.print(sb);
    }

    private static int nextInt(DataInputStream in) throws IOException {
        int ret = 0;
        int b = in.read();
        while (b < '0' || b > '9') b = in.read();
        while (b >= '0' && b <= '9') {
            ret = ret * 10 + (b - '0');
            b = in.read();
        }
        return ret;
    }
}
