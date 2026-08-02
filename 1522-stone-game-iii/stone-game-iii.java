class Solution {
    int [][]memo;
    int n;
     int fun(int[] s, int person, int i)
     {
        if(i>=n) return 0;

        if(memo[person][i]!=-1)  return memo[person][i];
         int result=(person==0)?Integer.MIN_VALUE:Integer.MAX_VALUE;
          int stones=0;
        for(int x=1;x<=Math.min(3,n-i);x++)
        {
            if(person==0)
            {
                stones+=s[i+x-1];
                result=Math.max(result,stones + fun(s,1,i+x));

                
            }else
            {
             result=Math.min(result, fun(s,0,i+x));
            }
        }
               return  memo[person][i] = result;
     }
    public String stoneGameIII(int[] s) {
      n=s.length;
     memo= new int[2][n];

     for(int i=0;i<2;i++)
     {
        
            Arrays.fill(memo[i],-1);
        
     }
     int total=Arrays.stream(s).sum();
     int p1=fun(s,0,0);
     int p2=total-p1;
     if(p1==p2) return "Tie";
     else if (p1>p2) return "Alice";
      return "Bob";
    }
}