package CodeForcesVIrtual67;
import java.util.*;
import java.io.*;
public class D {
    public static void main(String[] args) throws IOException {
        int LIMIT = 200000; // gives well over 10000 primes
        boolean[] comp = new boolean[LIMIT + 1];
        int[] primes = new int[20000];
        int pc = 0;
        for (int i = 2; i <= LIMIT; i++) {
            if (!comp[i]) {
                primes[pc++] = i;
                for (long j = (long) i * i; j <= LIMIT; j += i)
                    comp[(int) j] = true;
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            long[] a = new long[n];
            a[0] = primes[0];
            for (int k = 1; k <= n - 2; k++)
                a[k] = (long) primes[k - 1] * primes[k];
            a[n - 1] = primes[n - 2]; // works since n >= 2

            for (int i = 0; i < n; i++) {
                sb.append(a[i]);
                sb.append(i == n - 1 ? '\n' : ' ');
            }
        }

        System.out.print(sb);
    }
}
