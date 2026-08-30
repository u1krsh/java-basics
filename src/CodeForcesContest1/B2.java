package CodeForcesContest1;
import java.io.*;
import java.util.*;
public class B2 {
    public static void main(String[] args) throws IOException {
        DataInputStream in = new DataInputStream(new BufferedInputStream(System.in, 1 << 16));
        StringBuilder sb = new StringBuilder();

        int t = nextInt(in);
        final int KCAP = 19; // 2^18 > 2*10^5 >= any q, so completion always reached by round 19

        while (t-- > 0) {
            int n = nextInt(in);
            int m = nextInt(in);
            int[] freq = new int[m + 2];
            for (int i = 0; i < n; i++) {
                int v = nextInt(in);
                freq[v]++;
            }
            long[] P = new long[m + 2]; // P[x] = count of a_i <= x
            for (int x = 1; x <= m; x++) P[x] = P[x - 1] + freq[x];

            int kLimit = Math.min(m, KCAP);
            long[] ans = new long[m + 1];

            for (int k = 1; k <= kLimit; k++) {
                long best = 0;
                long cap = (1L << k) - 1;
                for (int T = 1; T <= m; T++) {
                    long total = 0;
                    int qmax = m / T;
                    for (int q = 1; q <= qmax; q++) {
                        int lo = q * T;
                        int hi = Math.min((q + 1) * T - 1, m);
                        long cnt = P[hi] - P[lo - 1];
                        if (cnt == 0) continue;
                        int L = (q == 1) ? 0 : (32 - Integer.numberOfLeadingZeros(q - 1));
                        boolean isPow2 = (q & (q - 1)) == 0;
                        if (k < L) {
                            total += cap * cnt;
                        } else if (k > L) {
                            total += (long) q * cnt;
                        } else if (!isPow2) {
                            total += (long) q * cnt;
                        } else {
                            long cntR0 = P[lo] - P[lo - 1]; // a_i == q*T exactly
                            long cntRpos = cnt - cntR0;
                            total += (long) q * cntR0 + cap * cntRpos;
                        }
                    }
                    if (total > best) best = total;
                }
                ans[k] = best;
            }

            if (m > KCAP) {
                long bestF = 0;
                for (int T = 1; T <= m; T++) {
                    long F = 0;
                    int qmax = m / T;
                    for (int q = 1; q <= qmax; q++) {
                        int lo = q * T;
                        int hi = Math.min((q + 1) * T - 1, m);
                        F += (long) q * (P[hi] - P[lo - 1]);
                    }
                    if (F > bestF) bestF = F;
                }
                for (int k = KCAP + 1; k <= m; k++) ans[k] = bestF;
            }

            for (int k = 1; k <= m; k++) {
                sb.append(ans[k]);
                sb.append(k == m ? '\n' : ' ');
            }
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
