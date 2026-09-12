package CodeForcesContest194;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class E {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null) return;

        StringTokenizer st = new StringTokenizer(line);
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        String s = br.readLine();

        int[] pref_1 = new int[n + 1];
        int[] pref_01 = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            pref_1[i] = pref_1[i - 1] + (s.charAt(i - 1) == '1' ? 1 : 0);
            pref_01[i] = pref_01[i - 1];
            if (i > 1 && s.charAt(i - 2) == '0' && s.charAt(i - 1) == '1') {
                pref_01[i]++;
            }
        }

        StringBuilder out = new StringBuilder();

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            int len = r - l + 1;
            long o = pref_1[r] - pref_1[l - 1];
            long z = len - o;

            long c0, c1;

            if (z == 0) {
                c0 = 0; c1 = 1;
            } else if (o == 0) {
                c0 = 1; c1 = 0;
            } else {
                long t_01 = pref_01[r] - pref_01[l];
                long c = t_01;
                if (s.charAt(r - 1) == '0' && s.charAt(l - 1) == '1') {
                    c++;
                }
                c0 = c; c1 = c;
            }

            long Cmax = Math.max(c0, c1);

            long k = Math.max((z + 1) / 2, (o + 1) / 2);
            k = Math.max(k, Cmax);
            k = Math.max(k, (z - c0 + Cmax + 1) / 2);
            k = Math.max(k, (o - c1 + Cmax + 1) / 2);
            k = Math.max(k, (z + o - c0 - c1 + Cmax + 2) / 3);

            out.append(4L * k - len).append("\n");
        }

        System.out.print(out);
    }
}

