class Solution {

    boolean check(int[] piles, int h, int x) {
        long sum = 0;
        for (int i = 0; i < piles.length; i++) {
            sum += (piles[i] + x - 1) / x;
        }
        return sum <= h;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = Arrays.stream(piles).max().getAsInt();
        int ans = r;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (check(piles, h, mid)) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }
}
