class Solution {
    public boolean stoneGame(int[] nums) {
        
        int[][] dp = new int[nums.length][nums.length];


        return solve(nums, 0,nums.length-1,dp)>=0;
        
    }

    public int solve(int[] nums, int left, int right, int[][] dp){

        if(left==right){
            return nums[left];
        }

        if(dp[left][right]!=0){
            return dp[left][right];
        }


        int leftAns = nums[left] - solve(nums, left+1,right,dp);
        int rightAns = nums[right] - solve(nums, left, right-1,dp);

        dp[left][right] = Math.max(leftAns, rightAns);

        return dp[left][right];
    }
}