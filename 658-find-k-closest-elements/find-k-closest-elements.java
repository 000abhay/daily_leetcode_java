class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;

        // Find first index with arr[idx] >= x
        int low = 0, high = n - 1;
        int idx = n;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= x) {
                idx = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        int l = idx - 1;
        int r = idx;

        List<Integer> ans = new ArrayList<>();

        while (ans.size() < k) {

            if (l < 0) {
                ans.add(arr[r++]);
            }
            else if (r >= n) {
                ans.add(arr[l--]);
            }
            else {
                int leftDist = Math.abs(arr[l] - x);
                int rightDist = Math.abs(arr[r] - x);

                if (leftDist <= rightDist) {
                    ans.add(arr[l--]);
                } else {
                    ans.add(arr[r++]);
                }
            }
        }

        Collections.sort(ans);
        return ans;
    }
}