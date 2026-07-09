class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
     
     int N=queries.length;
      boolean[] ans = new boolean[N];
      int [] save=new int[n];

      for(int i=0;i<n;i++) save[i]=i;
   int l=0,r=1;
      while(r<n)
      {
        if(nums[r]-nums[l]<=maxDiff)
        {
            save[r]=save[l];

            r++;
        }
        else
        {
            if(r-l==1)
            {
                 l=r;
                 r++;
            }
            else {
                l=r-1;

            }

        }

      }
      for(int i=0;i<n;i++) System.out.println(save[i]);
      int count=0;
      for(int[]x:queries)
      {
        if(save[x[0]]==save[x[1]]) ans[count++]=true;

        else ans[count++]=false;
      }
      return ans;  
    }
}