class Solution {
    public boolean checkDivisibility(int n) {
        int sum=0,pro=1;
         int ans=n;
         while(n>0)
         {
            int x=n%10;
            sum+=x;
            pro*=x;
            n/=10;
         }

         int f=sum+pro;
          // System.out.print(f);
         if(ans%f==0) return true;

        

        return false;
    }
}