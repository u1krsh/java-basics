package CodeForcesContest2;
import java.io.*;
import java.util.*;
public class E {

    public static void main(String[] args) throws IOException {
        DataInputStream in = new DataInputStream(new BufferedInputStream(System.in, 1 << 16));
        int t = nextInt(in);
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            int n = nextInt(in);
            int[] b = new int[n + 2]; // 1-indexed, b[1..n]
            for (int i = 1; i <= n; i++) b[i] = nextInt(in);

            int[] diff = new int[n + 2];
            for (int i = 1; i <= n; i++) {
                if (b[i] > 0) {
                      int d = b[i];
                    int lo = Math.max(1, i - d + 1);
                    int hi = Math.min(n, i + d - 1);
                    if (lo <= hi) {
                        diff[lo]++;
                        diff[hi + 1]--;
                    }
                }
            }
            boolean[] forbidden = new boolean[n + 2];
            int run = 0;
            for (int i = 1; i <= n; i++) {
                run += diff[i];
                forbidden[i] = run > 0;
            }

            boolean[] inS = new boolean[n + 2];
            boolean feasible = true;
            boolean hasKnown = false;

            for (int i = 1; i <= n && feasible; i++) {
                if (b[i] == 0) {
                    hasKnown = true;
                    if (forbidden[i]) {
                        feasible = false;
                    } else {
                        inS[i] = true;
                    }
                } else if (b[i] > 0) {
                    hasKnown = true;
                    int d = b[i];
                    int L = i - d;
                    int R = i + d;
                    boolean added = false;
                    if (L >= 1 && !forbidden[L]) {
                        inS[L] = true;
                        added = true;
                    }
                    if (R <= n && !forbidden[R]) {
                        inS[R] = true;
                        added = true;
                    }
                    if (!added) feasible = false;
                }
            }

            if (feasible && !hasKnown) {
                inS[1] = true;
            }

            if (feasible) {
                final int INF = Integer.MAX_VALUE / 2;
                int[] dist = new int[n + 2];
                Arrays.fill(dist, INF);
                boolean anySource = false;
                for (int i = 1; i <= n; i++) {
                    if (inS[i]) {
                        dist[i] = 0;
                        anySource = true;
                    }
                }
                for (int i = 2; i <= n; i++) dist[i] = Math.min(dist[i], dist[i - 1] + 1);
                for (int i = n - 1; i >= 1; i--) dist[i] = Math.min(dist[i], dist[i + 1] + 1);

                if (!anySource) {
                    feasible = false;
                } else {
                    for (int i = 1; i <= n; i++) {
                        if (b[i] != -1 && dist[i] != b[i]) {
                            feasible = false;
                            break;
                        }
                    }
                }
            }

            if (!feasible) {
                sb.append(-1).append('\n');
            } else {
                StringBuilder line = new StringBuilder(n);
                for (int i = 1; i <= n; i++) line.append(inS[i] ? '1' : '0');
                sb.append(line).append('\n');
            }
        }

        System.out.print(sb);
    }

    private static int nextInt(DataInputStream in) throws IOException {
        int ret = 0;
        int c = in.read();
        while (c != '-' && (c < '0' || c > '9')) c = in.read();
        boolean neg = false;
        if (c == '-') {
            neg = true;
            c = in.read();
        }
        while (c >= '0' && c <= '9') {
            ret = ret * 10 + (c - '0');
            c = in.read();
        }
        return neg ? -ret : ret;
    }
}
