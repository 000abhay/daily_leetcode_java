class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;

        // Find maximum element
        int maxEl = 0;
        for (int num : nums) {
            maxEl = Math.max(maxEl, num);
        }

        // Find the smallest power of 2 greater than maxEl
        int T = 1;
        while (T <= maxEl) {
            T <<= 1;
        }

        // s1 -> stores all possible XORs of pairs
        // s2 -> stores all possible XORs of triplets
        boolean[] s1 = new boolean[T];
        boolean[] s2 = new boolean[T];

        // Compute pair XORs
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                s1[nums[i] ^ nums[j]] = true;
            }
        }

        // Compute triplet XORs
        for (int i = 0; i < T; i++) {
            if (s1[i]) {
                for (int num : nums) {
                    s2[i ^ num] = true;
                }
            }
        }

        // Count unique XOR values
        int count = 0;
        for (int i = 0; i < T; i++) {
            if (s2[i]) {
                count++;
            }
        }

        return count;
    }
}