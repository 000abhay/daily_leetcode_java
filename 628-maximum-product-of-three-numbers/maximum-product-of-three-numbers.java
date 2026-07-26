class Solution {
    public int maximumProduct(int[] nums) {
         Arrays.sort(nums);
         int n=nums.length;
         if(nums[n-1]<0) return (nums[n-1]*nums[n-2]*nums[n-3]);
        int a=Integer.MIN_VALUE,b=Integer.MIN_VALUE,c=Integer.MIN_VALUE;
        int sum=Integer.MIN_VALUE;
        int ai=0,bi=0,aj=0,bj=0;
        int d=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++)
        {
            int s=nums[i];
            if(a<s)
            {
                bi=ai;
                ai=i;
                b=a;
                a=s;
            }
            else if(b<s)
            {  b=s;
               bi=i;
            }

            if(s<0)
            {
                s=Math.abs(s);
            if(c<s)
            {
                bj=aj;
                aj=i;
                d=c;
                c=s;
            }
            else if(d<s)
            {  d=s;
               bj=i;
            }
            }
            
        }
        // if(a*b<c*d) 
        // {
        //     ai=aj;
        //     bi=bj;
        //     a=c;
        //     b=d;
        // }
        System.out.print(ai+ " " + bi);
        int sum2=0,max_sum=0;
        for(int i=0;i<nums.length;i++)
        {
            if(i!=ai&&i!=bi&&a*b*nums[i]>sum) {
                sum=a*b*nums[i];
            }
            
            if(i!=aj&&i!=bj&&c*d*nums[i]>sum2) sum2=c*d*nums[i];

          
        }

       return (sum>sum2)?sum:sum2;
        
       
         
    }
}