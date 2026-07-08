import java.util.*;

class Solution {

    static final int MOD = 1_000_000_007;

    public int[] sumAndMultiply(String s, int[][] queries) {

        int n = s.length();

        ArrayList<Integer> digits = new ArrayList<>();
        ArrayList<Integer> pos = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int d = s.charAt(i) - '0';
            if (d != 0) {
                digits.add(d);
                pos.add(i);
            }
        }

        int m = digits.size();

        if (m == 0) {
            return new int[queries.length];
        }

        long[] prefixMod = new long[m];
        int[] prefixSum = new int[m];
        long[] pow10 = new long[m + 1];

        pow10[0] = 1;
        for (int i = 1; i <= m; i++) {
            pow10[i] = (pow10[i - 1] * 10) % MOD;
        }

        prefixMod[0] = digits.get(0);
        prefixSum[0] = digits.get(0);

        for (int i = 1; i < m; i++) {
            prefixMod[i] = (prefixMod[i - 1] * 10 + digits.get(i)) % MOD;
            prefixSum[i] = prefixSum[i - 1] + digits.get(i);
        }

        int[] ans = new int[queries.length];

        for (int k = 0; k < queries.length; k++) {

            int l = queries[k][0];
            int r = queries[k][1];

            int first = lowerBound(pos, l);
            int last = upperBound(pos, r) - 1;

            if (first > last || first == m || last < 0) {
                ans[k] = 0;
                continue;
            }

            int len = last - first + 1;

            int sum;
            long number;

            if (first == 0) {
                sum = prefixSum[last];
                number = prefixMod[last];
            } else {
                sum = prefixSum[last] - prefixSum[first - 1];

                number = (prefixMod[last]
                        - (prefixMod[first - 1] * pow10[len]) % MOD
                        + MOD) % MOD;
            }

            ans[k] = (int) ((number * sum) % MOD);
        }

        return ans;
    }

    private int lowerBound(ArrayList<Integer> list, int target) {
        int lo = 0, hi = list.size();
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (list.get(mid) < target)
                lo = mid + 1;
            else
                hi = mid;
        }
        return lo;
    }

    private int upperBound(ArrayList<Integer> list, int target) {
        int lo = 0, hi = list.size();
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (list.get(mid) <= target)
                lo = mid + 1;
            else
                hi = mid;
        }
        return lo;
    }
}