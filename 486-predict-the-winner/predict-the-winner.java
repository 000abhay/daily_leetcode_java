class Solution {
    int fun(int [] nums, int l, int r)
    {
       if(l>r) return 0;
       if(l==r) return nums[l];

       int take_l=nums[l]+Math.min(fun(nums,l+2,r),fun(nums,l+1,r-1));
       int take_r=nums[r]+Math.min(fun(nums,l+1,r-1),fun(nums,l,r-2));

     return Math.max(take_l,take_r);

    }
    public boolean predictTheWinner(int[] nums) {
        int total=Arrays.stream(nums).sum();
        int p1=fun(nums,0,nums.length-1);
        int p2=total-p1;
         return p1>=p2;

        
       
    }
}