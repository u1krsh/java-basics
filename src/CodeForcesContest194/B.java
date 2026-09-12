package CodeForcesContest194;
import java.util.*;
import java.io.*;
import java.util.StringTokenizer;
public class B {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());
            long k = Long.parseLong(st.nextToken());

            long lo = x;
            long hi = x + k - 1;
            long d = y - x;

            long total = 0;

            long r1End = Math.min(hi, d);
            if (lo <= r1End) {
                for (long m = lo; m <= r1End; m++) {
                    total += d % m;
                }
            }

            long r2Start = Math.max(lo, d + 1);
            if (r2Start <= hi) {
                long count = hi - r2Start + 1;
                total += count * d;
            }

            sb.append(total).append('\n');
        }
        System.out.print(sb);
    }
}

