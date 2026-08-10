class Solution {
    public boolean winnerSquareGame(int n) {
        boolean [][]dp= new boolean[n+1][2];
          dp[0][0]=true;
          dp[0][1]=false;

          List<Integer>store= new ArrayList<>();
          for(int i=1;i<=n;i++)
          {
             int a=i*i;
             if(a>n) break;

             store.add(a);
          }
        
        for(int i=1;i<=n;i++)
        {
            boolean b1=true,b2=true;
            for(int x:store)
            {
                if(x>i) break;
                if(dp[i-x][1]==false&&b1)
                {
                    //  System.out.print("df");
                    b1=false;
                    dp[i][0]=false;
                }

                if(dp[i-x][0]==true&&b2)
                {
                    b2=false;
                    dp[i][1]=true;
                }

                if(!b1 || !b2) break;
                
            }
            if(b1)
            {
              //  System.out.print("df");
                dp[i][0]=true;
            }
            if(b2)
            {
                dp[i][1]=false;
            }
        }

          for(int i=0;i<=n;i++)
          {
            System.out.println("bob: " + dp[i][0] + " Alice: " + dp[i][1]);
          }
          return  dp[n][1];
    }
}