package CodeForcesVIrtual67;
import java.util.*;
import java.io.*;
public class E {
    static class TrieNode {
        TrieNode[] child = new TrieNode[2];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        StringBuilder sb = new StringBuilder();

        in.nextToken();
        int t = (int) in.nval;
        final int BITS = 30; // covers values up to ~1e9

        while (t-- > 0) {
            in.nextToken();
            int n = (int) in.nval;
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                in.nextToken();
                a[i] = (long) in.nval;
            }

            TrieNode root = new TrieNode();
            long best = 0;

            for (long v : a) {
                // Query best XOR with numbers already inserted
                if (root.child[0] != null || root.child[1] != null) {
                    TrieNode node = root;
                    long cur = 0;
                    for (int b = BITS; b >= 0; b--) {
                        int bit = (int) ((v >> b) & 1);
                        int want = bit ^ 1;
                        if (node.child[want] != null) {
                            cur |= (1L << b);
                            node = node.child[want];
                        } else {
                            node = node.child[bit];
                        }
                    }
                    best = Math.max(best, cur);
                }
                // Insert v into trie
                TrieNode node = root;
                for (int b = BITS; b >= 0; b--) {
                    int bit = (int) ((v >> b) & 1);
                    if (node.child[bit] == null) node.child[bit] = new TrieNode();
                    node = node.child[bit];
                }
            }
            sb.append(best).append('\n');
        }

        System.out.print(sb);
    }
}
