package CodeForcesContest2;
import java.util.*;
import java.io.*;
public class A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            String s = br.readLine().trim();
            int ans = 0;
            for (int start = 0; start < n; start += k) {
                boolean allOwned = true;
                for (int j = start; j < start + k; j++) {
                    if (s.charAt(j) != '1') {
                        allOwned = false;
                        break;
                    }
                }
                if (allOwned) ans++;
            }
            sb.append(ans).append('\n');
        }
        System.out.print(sb);
    }
}
