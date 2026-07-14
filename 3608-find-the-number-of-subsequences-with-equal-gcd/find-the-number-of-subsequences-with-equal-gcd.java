class Solution {
    int gcd(int a,int b)
    {
        if(b==0) return a;

         return gcd(b,a%b);
    }
    // int[][][]memo;
     private static final int MOD=1_000_000_007;
    // int top_down(int[]nums,int i,int s1,int s2)
    // {
    //     if(i==nums.length)
    //     {
    //         if((s1!=0&&s2!=0)&&s1==s2) return 1;
    //         else return 0;
    //     }
    //     if(memo[i][s1][s2]!=-1) return memo[i][s1][s2];

    //     int skip=top_down(nums,i+1,s1,s2);
    //     int take_s1=top_down(nums,i+1,gcd(s1,nums[i]),s2);
    //     int take_s2=top_down(nums,i+1,s1,gcd(s2,nums[i]));

    //      long ans = (long) skip + take_s1 + take_s2;
    //      memo[i][s1][s2] = (int)(ans % MOD);
    //      return memo[i][s1][s2];

        
    // }
    public int subsequencePairCount(int[] nums) {
        // int n=nums.length;
        // int s=java.util.Arrays.stream(nums).max().getAsInt();
        // memo= new int[n+1][s+1][s+1];
        //  for(int i=0;i<n+1;i++)
        //  {
        //     for(int j=0;j<s+1;j++)
        //     {
        //         Arrays.fill(memo[i][j],-1);
        //     }
        //  }
        // return top_down(nums,0,0,0);



        // BOTTOM_ UP APPRAOCH 

        int n=nums.length;
        int s=Arrays.stream(nums).max().getAsInt();
      
      int [][] curr=new int[s+1][s+1];
      int [][]prev= new int[s+1][s+1];

      for(int i=s;i>=0;i--)
      {
        for(int j=s;j>=0;j--)
        {
            if((i!=0&&j!=0)&&i==j) prev[i][j]=1;
        }
      }
      for(int i=n-1;i>=0;i--)
      {
        for(int j=s;j>=0;j--)
        {
            for(int k=s;k>=0;k--)
            {
                int skip=prev[j][k];
                int take_s1=prev[gcd(nums[i],j)][k];
                int take_s2=prev[j][gcd(nums[i],k)];

                long l=(long)skip + take_s1 + take_s2;
                int res=(int) (l%MOD);
                curr[j][k]=res;
            }
        }

        for(int p=0;p<s+1;p++) prev[p]=curr[p].clone();
      }

       return curr[0][0];
    }
}