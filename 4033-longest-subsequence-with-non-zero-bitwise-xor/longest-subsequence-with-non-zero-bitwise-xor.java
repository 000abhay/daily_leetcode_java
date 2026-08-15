class Solution {
    public int longestSubsequence(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int x=0;
         while(x<n&&nums[x]==0)x++;
         if(x==n) return 0;

         int extra_zero=x;
         int a=n-x;
         int sum=0;
         for(int i=x;i<n;i++)
         {
              sum^=nums[i];
         }
         if(sum==0)  return a-1+extra_zero;
          return a+extra_zero;
    }
}