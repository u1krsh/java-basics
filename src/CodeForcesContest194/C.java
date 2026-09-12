package CodeForcesContest194;
import java.util.*;
import java.io.*;
import java.util.StringTokenizer;
public class C {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());
            long s = x + y;

            long best = 0;
            for (int bit = 30; bit >= 0; bit--) {
                long b = 1L << bit;
                if ((s & b) != 0 && best + b <= x) {
                    best += b;
                }
            }
            long ops = x - best;
            sb.append(s).append(' ').append(ops).append('\n');
        }
        System.out.print(sb);
    }
}
