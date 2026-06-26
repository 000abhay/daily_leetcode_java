class Solution {

   int[] fenwick;
    int idx;

    // Prefix sum query
    int give(int x) {
        int sum = 0;
        while (x > 0) {
            sum += fenwick[x];
            x -= (x & -x);
        }
        return sum;
    }

    // Point update
    void add(int val, int x) {
        while (x < fenwick.length) {
            fenwick[x] += val;
            x += (x & -x);
        }
    }

    int[] compress(int[] pre) {

        int[] temp = pre.clone();
        Arrays.sort(temp);

        HashMap<Integer, Integer> map = new HashMap<>();

        idx = 1;

        for (int x : temp) {
            if (!map.containsKey(x)) {
                map.put(x, idx++);
            }
        }

        int[] res = new int[pre.length];

        for (int i = 0; i < pre.length; i++) {
            res[i] = map.get(pre[i]);
        }

        return res;
    }

    public long countMajoritySubarrays(int[] nums, int target) {

        int n = nums.length;

        for (int i = 0; i < n; i++) {
            nums[i] = (nums[i] == target) ? 1 : -1;
        }

        int[] pre = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            pre[i] = pre[i - 1] + nums[i - 1];
        }

        int[] comp = compress(pre);

        fenwick = new int[idx + 1];

        long ans = 0;

        for (int x : comp) {

            // Number of previous prefix sums > current prefix sum
            ans += give(x-1);

            add(1, x);
        }

        return ans;

    }
}