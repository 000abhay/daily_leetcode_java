class Solution {
    int [] pre;
    int [][]memo;
   int  fun(int []stone,int l,int n)
     {

           if(l>=n) return 0;

           if(memo[l][n]!=-1) return memo[l][n];

        int sum=0,x;
         for(int i=l;i<=n;i++)
         {
            
          int a=(l==0)?pre[i]:(pre[i]-pre[l-1]);
          int b=pre[n]-pre[i];

          if(a<b)
          {
             x=a+fun(stone,l,i);

          }
          else if(b<a) {
              x=b+fun(stone,i+1,n);
          }
          else{
          x=Math.max(a+fun(stone,l,i),b+fun(stone,i+1,n));
          }
          
           sum=Math.max(sum,x);
         }
         return memo[l][n]=sum;
     }

    public int stoneGameV(int[] stone) {
         int n=stone.length;
        pre= new int[n];
        pre[0]=stone[0];
        memo= new int[n][n];
        for(int i=0;i<n;i++)
        {
            Arrays.fill(memo[i],-1);
        }
        for(int i=1;i<n;i++)
        {
         pre[i]=stone[i]+pre[i-1];
        }

        return  fun(stone,0,n-1);
    }
}