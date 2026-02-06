import java.util.Arrays;

class Solution {

    // lower bound: first index with nums[idx] >= x
    static int lowerBound(int[] nums, int l, int r, int x) {
        int ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] >= x) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    public int minRemoval(int[] nums, int k) {
        int n = nums.length;
        if (n <= 1) return 0;

        Arrays.sort(nums);
        int ans = n;   // worst case remove all

        for (int i = 0; i < n; i++) {
            // smallest allowed value
            int minVal = (nums[i] + k - 1) / k; // ceil(nums[i]/k)

            int idx = lowerBound(nums, 0, i, minVal);

            if (idx != -1) {
                int valid = i - idx + 1;
                ans = Math.min(ans, n - valid);
            }
        }
        return ans;
    }
}
