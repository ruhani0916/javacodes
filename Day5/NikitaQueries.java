import java.util.*;

public class NikitaQueries {

    public static void main(String[] args) {
        
    } static class Solution {

        public List<Integer> specialXor(int N, int Q, int[] a, int[][] query) {

            int totalXor = 0;
            for (int x : a)
                totalXor ^= x;

            int[] prefix = new int[N + 1];

            for (int i = 1; i <= N; i++)
                prefix[i] = prefix[i - 1] ^ a[i - 1];

            List<Integer> ans = new ArrayList<>();

            for (int i = 0; i < Q; i++) {

                int l = query[i][0];
                int r = query[i][1];

                int inside = prefix[r] ^ prefix[l - 1];

                ans.add(totalXor ^ inside);
            }

            return ans;
        }
    }
}