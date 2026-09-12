package CodeForcesContest194;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
public class D {
    static boolean check1(int n, String s) {
        long min_val = 0, max_val = 0;
        int p = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            min_val -= 1;
            max_val += 1;
            p = 1 - p; // Toggle parity

            if (c == '+') {
                if (min_val <= 0) min_val = (p == 1) ? 1 : 2;
            } else if (c == '-') {
                if (max_val >= 0) max_val = (p == 1) ? -1 : -2;
            } else if (c == '0') {
                min_val = Math.max(min_val, 0L);
                max_val = Math.min(max_val, 0L);
                if (p != 0) return false;
            }
            if (min_val > max_val) return false;
        }
        return true;
    }

    static class Interval implements Comparable<Interval> {
        long l, r;
        Interval(long l, long r) {
            this.l = l;
            this.r = r;
        }

        @Override
        public int compareTo(Interval o) {
            if (this.l != o.l) return Long.compare(this.l, o.l);
            return Long.compare(this.r, o.r);
        }
    }

    // O(n) interval tracking for K >= 2
    static boolean checkK(long K, int n, String s) {
        ArrayList<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(0, 0));

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            ArrayList<Interval> next_intervals = new ArrayList<>();
            for (Interval iv : intervals) {
                long l = iv.l;
                long r = iv.r;
                if (l == r) {
                    next_intervals.add(new Interval(l - K, l - 1));
                    next_intervals.add(new Interval(l + 1, l + K));
                } else {
                    next_intervals.add(new Interval(l - K, r + K));
                }
            }

            ArrayList<Interval> filtered = new ArrayList<>();
            for (Interval iv : next_intervals) {
                long l = iv.l;
                long r = iv.r;
                if (c == '0') {
                    l = Math.max(l, 0L);
                    r = Math.min(r, 0L);
                } else if (c == '+') {
                    l = Math.max(l, 1L);
                } else if (c == '-') {
                    r = Math.min(r, -1L);
                }
                if (l <= r) {
                    filtered.add(new Interval(l, r));
                }
            }

            if (filtered.isEmpty()) return false;

            Collections.sort(filtered);
            intervals.clear();
            intervals.add(filtered.get(0));
            for (int j = 1; j < filtered.size(); j++) {
                Interval last = intervals.get(intervals.size() - 1);
                Interval curr = filtered.get(j);
                if (curr.l <= last.r + 1) {
                    last.r = Math.max(last.r, curr.r);
                } else {
                    intervals.add(curr);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null) return;

        int t = Integer.parseInt(line.trim());
        StringBuilder out = new StringBuilder();

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine().trim();

            long low = 1, high = n + 5;
            long ans = -1;

            while (low <= high) {
                long mid = low + (high - low) / 2;
                boolean possible = (mid == 1) ? check1(n, s) : checkK(mid, n, s);

                if (possible) {
                    ans = mid;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            out.append(ans).append("\n");
        }
        System.out.print(out);
    }
}
