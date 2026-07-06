class Solution {
    public int removeCoveredIntervals(int[][] inter) {
        Arrays.sort(inter,(a,b)->{
             if(a[0]!=b[0]) return Integer.compare(a[0],b[0]);

             return Integer.compare(b[1],a[1]);

        });
        int n=inter.length;
        int ans=n;
         int dom=-1;
         for(int i=1;i<n;i++)
         {
             if(dom==-1)
             { 
                if(inter[i-1][0]<=inter[i][0]&&inter[i-1][1]>=inter[i][1])
                {
                   dom=i-1;
                   ans--;

                }

             }
             else
             {
                 if(inter[dom][0]<=inter[i][0]&&inter[dom][1]>=inter[i][1])
                 {
                    ans--;
                 }
                 else
                 {
                    dom=-1;
                      if(inter[i-1][0]<=inter[i][0]&&inter[i-1][1]>=inter[i][1])
                    {
                      dom=i-1;
                      ans--;

                   }

                 }
             }
         }
        
        return ans;
    }
}