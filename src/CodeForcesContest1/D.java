package CodeForcesContest1;
import java.util.*;
import java.io.*;

public class D {
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }

    static class Event implements Comparable<Event> {
        long x;
        int type;
        int val;

        public Event(long x, int type, int val) {
            this.x = x;
            this.type = type;
            this.val = val;
        }

        @Override
        public int compareTo(Event other) {
            return Long.compare(this.x, other.x);
        }
    }

    static class Block {
        int type;
        long len;

        public Block(int type, long len) {
            this.type = type;
            this.len = len;
        }
    }

    static class DPState {
        long carry;
        List<Long> ms;

        public DPState(long carry, List<Long> ms) {
            this.carry = carry;
            this.ms = ms;
        }
    }

    static int compareLists(List<Long> a, List<Long> b) {
        int len = Math.min(a.size(), b.size());
        for (int i = 0; i < len; i++) {
            int cmp = Long.compare(a.get(i), b.get(i));
            if (cmp != 0) return cmp;
        }
        return Integer.compare(a.size(), b.size());
    }

    static void insertSortedDesc(List<Long> list, long val) {
        int pos = Collections.binarySearch(list, val, Collections.reverseOrder());
        if (pos < 0) pos = -(pos + 1);
        list.add(pos, val);
    }

    static void addState(List<DPState> next_dp, long carry, List<Long> ms) {
        for (DPState p : next_dp) {
            if (p.carry == carry) {
                if (compareLists(ms, p.ms) > 0) {
                    p.ms = ms;
                }
                return;
            }
        }
        next_dp.add(new DPState(carry, ms));
    }

    public static void solve(FastScanner in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();

        List<Event> events = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            long l = in.nextLong();
            long r = in.nextLong();
            events.add(new Event(l, 1, 1));
            events.add(new Event(r + 1, 1, -1));
        }
        for (int j = 0; j < m; j++) {
            long l = in.nextLong();
            long r = in.nextLong();
            events.add(new Event(l, 2, 1));
            events.add(new Event(r + 1, 2, -1));
        }

        Collections.sort(events);

        List<Block> blocks = new ArrayList<>();
        long prev_x = -1;
        int c1 = 0, c2 = 0;

        for (int i = 0; i < events.size(); ) {
            long curr_x = events.get(i).x;
            if (prev_x != -1 && curr_x > prev_x) {
                long len = curr_x - prev_x;
                int st = 0;
                if (c1 > 0 && c2 > 0) st = 3;
                else if (c1 > 0) st = 1;
                else if (c2 > 0) st = 2;

                if (st > 0) {
                    if (!blocks.isEmpty() && blocks.get(blocks.size() - 1).type == st) {
                        blocks.get(blocks.size() - 1).len += len;
                    } else {
                        blocks.add(new Block(st, len));
                    }
                } else {
                    blocks.add(new Block(0, len));
                }
            }
            while (i < events.size() && events.get(i).x == curr_x) {
                if (events.get(i).type == 1) c1 += events.get(i).val;
                else c2 += events.get(i).val;
                i++;
            }
            prev_x = curr_x;
        }

        List<List<Block>> comps = new ArrayList<>();
        List<Block> cur = new ArrayList<>();
        for (Block b : blocks) {
            if (b.type == 0) {
                if (!cur.isEmpty()) comps.add(new ArrayList<>(cur));
                cur.clear();
            } else {
                cur.add(b);
            }
        }
        if (!cur.isEmpty()) comps.add(new ArrayList<>(cur));

        List<Long> global_ans = new ArrayList<>();

        for (List<Block> comp : comps) {
            boolean changed = true;
            while (changed) {
                changed = false;
                List<Block> nxt = new ArrayList<>();
                for (int i = 0; i < comp.size(); i++) {
                    if (i + 2 < comp.size() && comp.get(i).type == comp.get(i + 2).type &&
                            comp.get(i).type != 3 && comp.get(i + 1).type == 3) {
                        long nlen = comp.get(i).len + comp.get(i + 1).len + comp.get(i + 2).len;
                        nxt.add(new Block(comp.get(i).type, nlen));
                        i += 2;
                        while (i + 1 < comp.size()) {
                            i++;
                            nxt.add(comp.get(i));
                        }
                        changed = true;
                        break;
                    } else {
                        nxt.add(comp.get(i));
                    }
                }
                if (changed) {
                    comp.clear();
                    for (Block b : nxt) {
                        if (!comp.isEmpty() && comp.get(comp.size() - 1).type == b.type) {
                            comp.get(comp.size() - 1).len += b.len;
                        } else {
                            comp.add(b);
                        }
                    }
                }
            }

            List<Block> comp2 = new ArrayList<>();
            for (int i = 0; i < comp.size(); i++) {
                comp2.add(comp.get(i));
                if (i + 1 < comp.size()) {
                    int t1 = comp.get(i).type;
                    int t2 = comp.get(i + 1).type;
                    if ((t1 == 1 && t2 == 2) || (t1 == 2 && t2 == 1)) {
                        comp2.add(new Block(3, 0));
                    }
                }
            }
            comp = comp2;

            if (!comp.isEmpty()) {
                if (comp.get(0).type == 3) {
                    int to_prepend = (comp.size() > 1 && comp.get(1).type == 1) ? 2 : 1;
                    comp.add(0, new Block(to_prepend, 0));
                }
                if (comp.get(comp.size() - 1).type == 3) {
                    int to_append = (comp.size() > 1 && comp.get(comp.size() - 2).type == 1) ? 2 : 1;
                    comp.add(new Block(to_append, 0));
                }
            }

            List<Long> V = new ArrayList<>();
            List<Long> E = new ArrayList<>();
            for (int i = 0; i < comp.size(); i++) {
                if (i % 2 == 0) V.add(comp.get(i).len);
                else E.add(comp.get(i).len);
            }

            List<DPState> dp = new ArrayList<>();
            dp.add(new DPState(0, new ArrayList<>()));

            for (int i = 0; i < V.size(); i++) {
                List<DPState> next_dp = new ArrayList<>();
                long base_W = V.get(i);

                for (DPState p : dp) {
                    long carry = p.carry;
                    List<Long> ms = p.ms;
                    long W = base_W + carry;

                    if (i == V.size() - 1) {
                        List<Long> n_ms = new ArrayList<>(ms);
                        if (W > 0) insertSortedDesc(n_ms, W);
                        addState(next_dp, 0, n_ms);
                    } else {
                        long E_val = E.get(i);

                        long W0 = W + E_val;
                        List<Long> ms0 = new ArrayList<>(ms);
                        if (W0 > 0) insertSortedDesc(ms0, W0);
                        addState(next_dp, 0, ms0);

                        long W1 = W;
                        List<Long> ms1 = new ArrayList<>(ms);
                        if (W1 > 0) insertSortedDesc(ms1, W1);
                        addState(next_dp, E_val, ms1);
                    }
                }
                dp = next_dp;
            }

            global_ans.addAll(dp.get(0).ms);
        }

        Collections.sort(global_ans, Collections.reverseOrder());
        out.println(global_ans.size());
        for (int i = 0; i < global_ans.size(); i++) {
            out.print(global_ans.get(i) + (i + 1 == global_ans.size() ? "" : " "));
        }
        out.println();
    }

    public static void main(String[] args) {
        FastScanner in = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        String tStr = in.next();
        if (tStr != null && !tStr.isEmpty()) {
            int t = Integer.parseInt(tStr);
            while (t-- > 0) {
                solve(in, out);
            }
        }
        out.flush();
    }
}
