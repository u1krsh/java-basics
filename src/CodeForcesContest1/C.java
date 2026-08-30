package CodeForcesContest1;
import java.util.*;
import java.io.*;
public class C {
    static StreamTokenizer in;
    static PrintWriter out;
    static int n;

    public static void main(String[] args) throws IOException {
        in = new StreamTokenizer(new BufferedInputStream(System.in));
        out = new PrintWriter(new BufferedOutputStream(System.out));
        int t = nextInt();
        while (t-- > 0) {
            n = nextInt();
            solve();
        }
        out.flush();
    }

    static int nextInt() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }

    static boolean query(int u, int v, int d) throws IOException {
        out.println("? " + u + " " + v + " " + d);
        out.flush();
        int res = nextInt();
        if (res == -1) {
            System.exit(0);
        }
        return res == 1;
    }

    static int findExactFrom(int u, int v, int knownLow) throws IOException {
        int prevTrue = knownLow;
        int step = 1;
        while (true) {
            int test = prevTrue + step;
            if (test > n - 1) test = n - 1;
            if (test == prevTrue) {
                return prevTrue;
            }
            if (query(u, v, test)) {
                prevTrue = test;
                step *= 2;
            } else {
                int lo2 = prevTrue, hi2 = test - 1;
                while (lo2 < hi2) {
                    int mid = lo2 + (hi2 - lo2 + 1) / 2;
                    if (query(u, v, mid)) lo2 = mid; else hi2 = mid - 1;
                }
                return lo2;
            }
        }
    }

    static int attemptImprove(int u, int v, int D) throws IOException {
        int test = D + 1;
        if (test > n - 1) return -1;
        if (!query(u, v, test)) return -1;
        return findExactFrom(u, v, test);
    }

    static void solve() throws IOException {
        int a = 1, b = 2;
        int D = findExactFrom(1, 2, 1);

        for (int v = 3; v <= n; v++) {
            if (D >= n - 1) break;

            int r1 = attemptImprove(a, v, D);
            int r2 = attemptImprove(b, v, D);

            if (r1 == -1 && r2 == -1) continue;

            if (r1 != -1 && (r2 == -1 || r1 >= r2)) {
                D = r1;
                b = v;
            } else {
                D = r2;
                a = b;
                b = v;
            }
        }

        out.println("! " + a + " " + b + " " + D);
        out.flush();
    }
}
