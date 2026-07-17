import java.util.*;

class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int max = 0;
        for (int x : nums) max = Math.max(max, x);

        int[] freq = new int[max + 1];
        for (int x : nums) freq[x]++;

        // cnt[d] = how many numbers are divisible by d
        int[] cnt = new int[max + 1];
        for (int d = 1; d <= max; d++) {
            for (int j = d; j <= max; j += d) {
                cnt[d] += freq[j];
            }
        }

        // gcdCnt[d] = number of pairs with gcd exactly d
        long[] gcdCnt = new long[max + 1];
        for (int d = max; d >= 1; d--) {
            long pairs = 1L * cnt[d] * (cnt[d] - 1) / 2;
            for (int j = d + d; j <= max; j += d) {
                pairs -= gcdCnt[j];
            }
            gcdCnt[d] = pairs;
        }

        // Prefix sums of gcd counts
        List<Integer> values = new ArrayList<>();
        List<Long> prefix = new ArrayList<>();

        long sum = 0;
        for (int d = 1; d <= max; d++) {
            if (gcdCnt[d] == 0) continue;
            sum += gcdCnt[d];
            values.add(d);
            prefix.add(sum);
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            long k = queries[i] + 1; // queries are 0-indexed

            int idx = lowerBound(prefix, k);
            ans[i] = values.get(idx);
        }

        return ans;
    }

    private int lowerBound(List<Long> arr, long target) {
        int l = 0, r = arr.size() - 1;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (arr.get(mid) >= target)
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }
}