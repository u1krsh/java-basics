package CodeForcesContest1;
import java.io.*;
import java.util.*;
public class FF {
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    String line = br.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

    static int n;
    static int[] a;
    static List<Integer>[] adj;
    static int[] l, r;
    static long ans;

    static void dfs1(int u, int p) {
        int sumL = 0;
        int sumR = 0;
        for (int v : adj[u]) {
            if (v != p) {
                dfs1(v, u);
                sumL += l[v];
                sumR += r[v];
            }
        }
        if (a[u] != 0) {
            l[u] = sumL + a[u];
            r[u] = sumR + a[u];
        } else {
            l[u] = sumL - 1;
            r[u] = sumR + 1;
        }
    }

    static void dfs2(int u, int p, int target) {
        ans += Math.abs(target);

        List<Integer> children = new ArrayList<>();
        int curSumL = 0;
        int curSumR = 0;
        for (int v : adj[u]) {
            if (v != p) {
                children.add(v);
                curSumL += l[v];
                curSumR += r[v];
            }
        }

        if (children.isEmpty()) return;

        int rem = target - (a[u] != 0 ? a[u] : 0);
        int chosen_a = 0;
        if (a[u] == 0) {
            if ((rem - 1 - curSumL) % 2 == 0 && rem - 1 >= curSumL && rem - 1 <= curSumR) {
                chosen_a = 1;
            } else {
                chosen_a = -1;
            }
            rem -= chosen_a;
        }

        int curSum = curSumL;
        int[] childTarget = new int[children.size()];
        for (int i = 0; i < children.size(); i++) {
            childTarget[i] = l[children.get(i)];
        }

        for (int i = 0; i < children.size(); i++) {
            int v = children.get(i);
            int canAdd = r[v] - l[v];
            int add = Math.min(rem - curSum, canAdd);
            childTarget[i] += add;
            curSum += add;
        }

        for (int i = 0; i < children.size(); i++) {
            dfs2(children.get(i), u, childTarget[i]);
        }
    }

    public static void solve(FastScanner in, PrintWriter out) {
        n = in.nextInt();
        a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = in.nextInt();
        }

        adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            adj[u].add(v);
            adj[v].add(u);
        }

        l = new int[n + 1];
        r = new int[n + 1];
        dfs1(1, 0);

        int rootTarget = 0;
        if (0 >= l[1] && 0 <= r[1]) {
            rootTarget = 0;
        } else if (0 < l[1]) {
            rootTarget = l[1];
        } else {
            rootTarget = r[1];
        }

        ans = 0;
        dfs2(1, 0, rootTarget);
        out.println(ans);
    }

    public static void main(String[] args) {
        FastScanner in = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        String tStr = in.next();
        if (tStr != null) {
            int t = Integer.parseInt(tStr);
            while (t-- > 0) {
                solve(in, out);
            }
        }
        out.flush();
    }
}
