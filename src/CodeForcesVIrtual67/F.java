package CodeForcesVIrtual67;
import java.util.*;
import java.io.*;
public class F {
    public static void main(String[] args) throws IOException {
        DataInputStream in = new DataInputStream(new BufferedInputStream(System.in, 1 << 16));
        int t = nextInt(in);
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            int x = nextInt(in);
            int y = nextInt(in);
            int n = x + y;

            boolean isEven = (n % 2 == 0);
            int maxX = n / 2;
            int minX = isEven ? 1 : 0;

            if (x < minX || x > maxX) {
                sb.append("NO\n");
                continue;
            }

            sb.append("YES\n");

            int xp = x - (isEven ? 1 : 0);
            int m = 2 * xp;
            int L = m + 1;
            int k = n - L;

            // chain: 1-2, 2-3, ..., (L-1)-L
            for (int i = 1; i < L; i++) {
                sb.append(i).append(' ').append(i + 1).append('\n');
            }
            for (int i = L + 1; i <= n; i++) {
                sb.append(1).append(' ').append(i).append('\n');
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
