class Solution {
    public boolean winnerSquareGame(int n) {
        boolean []b1= new boolean[n+1];
          for(int i=1;i<=n;i++)
          {
             for(int j=1;j*j<=i;j++)
             {
                 int sq=j*j;
                 if(!b1[i-sq])  
                 {b1[i]=true;
                      break;
                 }

             }
          }
        return b1[n];
    }
}