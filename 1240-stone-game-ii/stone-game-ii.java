class Solution {
    int[][][]memo= new int[2][101][101];

    int fun(int[] piles,int person, int i,int m,int n)
    {
        if(i>=n) return 0;

        if(memo[person][i][m]!=-1)   return memo[person][i][m];
           
        int result=(person==0)?-1:Integer.MAX_VALUE;
        int stones=0;
        for(int x=1;x<=Math.min(2*m,n-i);x++)
        {
            
            if(person==0)
            {
               stones+=piles[i+x-1];
               result=Math.max(result,stones+ fun(piles,1,i+x,Math.max(m,x),n));   
            }
            else
            {
                result=Math.min(result,fun(piles,0,i+x,Math.max(x,m),n));
            }

            
        }



        return memo[person][i][m]=result;
    }
    
    public int stoneGameII(int[] piles) {
          int n=piles.length;
          for(int i=0;i<2;i++)
          {
            for(int j=0;j<101;j++)
            {
                Arrays.fill(memo[i][j],-1);
            }
          }
        
        return fun(piles,0,0,1,n);
    }
}