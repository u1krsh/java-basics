package CodeForcesContest2;
import java.util.*;
import java.io.*;

public class d {
    public static void main(String[] args) throws IOException {
        DataInputStream in = new DataInputStream(new BufferedInputStream(System.in, 1 << 16));
        int t = nextInt(in);
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = nextInt(in);
            int[] a = new int[n];
            int[] cnt = new int[n + 2];
            for (int i = 0; i < n; i++) {
                int v = nextInt(in);
                a[i] = v;
                if (v <= n) cnt[v]++;
            }
            if (cnt[0] == 1) {
                sb.append("NO\n");
                continue;
            }
            sb.append("YES\n");
            char[] res = new char[n];
            if (cnt[0] == 0) {
                Arrays.fill(res, 'A');
            } else {
                int M = 0;
                while (M <= n && cnt[M] != 0) M++;
                int T3 = 0;
                while (T3 < M && cnt[T3] >= 3) T3++;
                int[] occ = new int[n + 2];
                int c0 = (T3 < M) ? cnt[T3] : -1;
                for (int i = 0; i < n; i++) {
                    int v = a[i];
                    if (T3 == M) {
                        if (v < M) {
                            int idx = occ[v]++;
                            res[i] = (idx == 0) ? 'A' : (idx == 1) ? 'B' : (idx == 2) ? 'C' : 'A';
                        } else {
                            res[i] = 'A';
                        }
                    } else {
                        if (v < T3) {
                            int idx = occ[v]++;
                            res[i] = (idx == 0) ? 'A' : (idx == 1) ? 'B' : (idx == 2) ? 'C' : 'A';
                        } else if (v == T3) {
                            int idx = occ[v]++;
                            res[i] = (c0 == 2) ? ((idx == 0) ? 'A' : 'B') : 'A';
                        } else {
                            res[i] = 'C';
                        }
                    }
                }
            }
            sb.append(new String(res)).append('\n');
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
