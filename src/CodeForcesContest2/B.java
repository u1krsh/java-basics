package CodeForcesContest2;
import java.util.*;
import java.io.*;

public class B {
    public static void main(String[] args) throws IOException {
        DataInputStream in = new DataInputStream(new BufferedInputStream(System.in, 1 << 16));
        int t = nextInt(in);
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = nextInt(in);
            int oddCount = 0, mod0Count = 0, mod2Count = 0;
            for (int i = 0; i < n; i++) {
                long a = nextLong(in);
                if ((a & 1) == 1) {
                    oddCount++;
                } else {
                    if (a % 4 == 0) mod0Count++;
                    else mod2Count++;
                }
            }
            int ans = Math.max(oddCount, Math.max(mod0Count, mod2Count));
            sb.append(ans).append('\n');
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
    private static long nextLong(DataInputStream in) throws IOException {
        long ret = 0;
        int b = in.read();
        while (b < '0' || b > '9') b = in.read();
        while (b >= '0' && b <= '9') {
            ret = ret * 10 + (b - '0');
            b = in.read();
        }
        return ret;
    }
}
