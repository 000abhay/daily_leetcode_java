class Solution {
    public int lengthOfLIS(int[] nums) {
          ArrayList<Integer> tails = new ArrayList<>();

        for (int x : nums) {
            int left = 0, right = tails.size() - 1;

        
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (tails.get(mid) >= x) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            
            if (left == tails.size()) {
                tails.add(x);       
            } else {
                tails.set(left, x); 
            }
        }

        return tails.size();
    }
}