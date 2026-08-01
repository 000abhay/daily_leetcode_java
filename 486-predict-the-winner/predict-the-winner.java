class Solution {
    int fun(int [] nums, int l, int r,int total,boolean flag)
    {
        if(l>r)  return total;
       int ans=0;
       if(flag){
           int a=fun(nums,l+1,r,total+nums[l],!flag);
           int b=fun(nums,l,r-1,total+nums[r],!flag);
           ans=Math.max(a,b);
        

       }
       else
       {
         int c=fun(nums,l+1, r,total, !flag);
         int d=fun(nums,l,r-1,total,!flag);
         ans=Math.min(c,d);
       }
        return ans;


    }
    public boolean predictTheWinner(int[] nums) {
        int total=Arrays.stream(nums).sum();
        int x=fun(nums,0,nums.length-1,0,true);
        if(total%2==0)
        {
            if(x>=(total/2))  return true;
             return false;

        }
         total=(total/2) +1;
         if(x>=(total)) return true;
         return false;
    }
}