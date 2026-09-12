package CodeForcesContest194;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class F {
    static class Edge {
        int to;
        int idx;
        Edge(int to, int idx) {
            this.to = to;
            this.idx = idx;
        }
    }

    static ArrayList<Edge>[] adj;
    static ArrayList<Edge>[] trimmed_adj;
    static int[] deg;
    static boolean[] in_path;
    static boolean[] in_C;
    static boolean[] vis_bfs;
    static boolean[] vis_dfs;
    static int[] path;
    static int path_sz;
    static boolean found;
    static int n, m;

    static boolean checkCycle() {
        for (int i = 0; i < path_sz; i++) {
            in_path[path[i]] = true;
        }
        for (int i = 0; i < path_sz; i++) {
            int u = path[i];
            int v = path[(i + 1) % path_sz];
            for (Edge edge : adj[u]) {
                if (edge.to == v) {
                    in_C[edge.idx] = true;
                    break;
                }
            }
        }

        int count = 0;
        int[] q = new int[n + 1];
        int head = 0, tail = 0;

        q[tail++] = path[0];
        vis_bfs[path[0]] = true;

        ArrayList<Integer> touched = new ArrayList<>();
        touched.add(path[0]);

        while (head < tail) {
            int u = q[head++];
            if (in_path[u]) count++;

            for (Edge edge : adj[u]) {
                if (!in_C[edge.idx] && !vis_bfs[edge.to]) {
                    vis_bfs[edge.to] = true;
                    q[tail++] = edge.to;
                    touched.add(edge.to);
                }
            }
        }

        for (int u : touched) vis_bfs[u] = false;
        for (int i = 0; i < path_sz; i++) in_path[path[i]] = false;
        for (int i = 0; i < path_sz; i++) {
            int u = path[i];
            int v = path[(i + 1) % path_sz];
            for (Edge edge : adj[u]) {
                if (edge.to == v) {
                    in_C[edge.idx] = false;
                    break;
                }
            }
        }

        return count == path_sz;
    }

    static void dfs(int u, int start) {
        if (found) return;
        vis_dfs[u] = true;
        path[path_sz++] = u;

        for (Edge edge : trimmed_adj[u]) {
            int v = edge.to;
            if (v == start) {
                if (path_sz >= 3) {
                    if (checkCycle()) {
                        found = true;
                        return;
                    }
                }
            } else if (!vis_dfs[v] && v > start) {
                dfs(v, start);
            }
            if (found) break;
        }

        path_sz--;
        vis_dfs[u] = false;
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null) return;

        int t = Integer.parseInt(line.trim());
        StringBuilder out = new StringBuilder();

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            adj = new ArrayList[n + 1];
            trimmed_adj = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) {
                adj[i] = new ArrayList<>();
                trimmed_adj[i] = new ArrayList<>();
            }
            deg = new int[n + 1];

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                adj[u].add(new Edge(v, i));
                adj[v].add(new Edge(u, i));
                deg[u]++;
                deg[v]++;
            }

            if (m <= n) {
                out.append("NO\n");
                continue;
            }

            int[] leafQ = new int[n + 1];
            int head = 0, tail = 0;
            for (int i = 1; i <= n; i++) {
                if (deg[i] == 1) leafQ[tail++] = i;
            }

            while (head < tail) {
                int u = leafQ[head++];
                deg[u] = 0;
                for (Edge edge : adj[u]) {
                    int v = edge.to;
                    if (deg[v] > 0) {
                        deg[v]--;
                        if (deg[v] == 1) leafQ[tail++] = v;
                    }
                }
            }

            for (int u = 1; u <= n; u++) {
                if (deg[u] > 0) {
                    for (Edge edge : adj[u]) {
                        if (deg[edge.to] > 0) {
                            trimmed_adj[u].add(edge);
                        }
                    }
                }
            }

            in_path = new boolean[n + 1];
            in_C = new boolean[m];
            vis_bfs = new boolean[n + 1];
            vis_dfs = new boolean[n + 1];
            path = new int[n + 1];
            path_sz = 0;
            found = false;

            for (int i = 1; i <= n; i++) {
                if (deg[i] > 0) {
                    dfs(i, i);
                    if (found) break;
                }
            }

            if (found) {
                out.append("YES\n");
            } else {
                out.append("NO\n");
            }
        }
        System.out.print(out);
    }
}
