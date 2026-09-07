package CodeForcesContest2;

import java.util.*;
import java.io.*;

public class c {
    public static void main(String[] args) throws IOException {
        DataInputStream in = new DataInputStream(new BufferedInputStream(System.in, 1 << 16));
        int t = nextInt(in);
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = nextInt(in);
            int[] a = new int[n + 1];
            int[] fList = new int[n];
            int fCount = 0;
            int[] cList = new int[n];
            int cCount = 0;
            for (int i = 1; i <= n; i++) {
                int v = nextSignedInt(in);
                a[i] = v;
                if (v == 1) fList[fCount++] = i;
                else if (v == -1) cList[cCount++] = i;
            }
            int best = 0;
            int type = 0;
            if (fCount >= 2) {
                for (int k = 0; k < fCount - 1; k++) {
                    int gap = fList[k + 1] - fList[k] + 1;
                    if (gap > best) { best = gap; type = 0; }
                }
            }
            if (fCount >= 1) {
                if (best < 1) { best = 1; type = 0; }
                int f1 = fList[0];
                int fp = fList[fCount - 1];
                if (cCount > 0 && cList[0] < f1) {
                    int gap = f1 - cList[0] + 1;
                    if (gap > best) { best = gap; type = 1; }
                }
                if (cCount > 0 && cList[cCount - 1] > fp) {
                    int gap = cList[cCount - 1] - fp + 1;
                    if (gap > best) { best = gap; type = 2; }
                }
            } else {
                if (cCount >= 2) {
                    best = cList[cCount - 1] - cList[0] + 1;
                    type = 3;
                } else if (cCount == 1) {
                    best = 1;
                    type = 4;
                } else {
                    best = 0;
                    type = 0;
                }
            }
            int[] out = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                out[i] = (a[i] == 1) ? 1 : 0;
            }
            if (type == 1) {
                out[cList[0]] = 1;
            } else if (type == 2) {
                out[cList[cCount - 1]] = 1;
            } else if (type == 3) {
                out[cList[0]] = 1;
                out[cList[cCount - 1]] = 1;
            } else if (type == 4) {
                out[cList[0]] = 1;
            }
            for (int i = 1; i <= n; i++) {
                sb.append(out[i]);
                if (i < n) sb.append(' ');
            }
            sb.append('\n');
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

    private static int nextSignedInt(DataInputStream in) throws IOException {
        int b = in.read();
        while (b != '-' && (b < '0' || b > '9')) b = in.read();
        boolean neg = false;
        if (b == '-') { neg = true; b = in.read(); }
        int ret = 0;
        while (b >= '0' && b <= '9') {
            ret = ret * 10 + (b - '0');
            b = in.read();
        }
        return neg ? -ret : ret;
    }
}