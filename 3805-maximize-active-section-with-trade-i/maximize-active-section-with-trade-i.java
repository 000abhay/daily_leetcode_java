class Solution {
    int total_ones(String s)
    {
        int count=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='1') count++;
        }
         return count;
    }
    public int maxActiveSectionsAfterTrade(String s) {
        int n=s.length();
        int count=0;
        int max=0;
         int l=0,r;
         int i=-1,j=-1;
         while(l<n&&s.charAt(l)=='1') l++;
            r=l;
           if(r==n) return  total_ones(s);
                
         while(r<n)
         {
            //b1=false;
             while(r<n&&s.charAt(r)=='0') r++;


                if(r==n)
                {
                    if(max==0) return  total_ones(s);
                     break;
                }



              int temp_one=0;
              int idx=-1;
               while(r<n&&s.charAt(r)=='1')
               {
                 r++;
                 temp_one++;
               }
               idx=r;
                 if(r==n)
                {
                    if(max==0) return  total_ones(s);
                     break;
                }




                while(r<n&&s.charAt(r)=='0') r++;

                 r--;
                 int zero=((r-l)+1)-temp_one;
                  if(max<zero)
                  {
                    max=zero;
                    i=l;
                    j=r;
                  }
                 l=idx;







             


         }
      int sum=0;
      if(i==-1||j==-1) return total_ones(s);

         for(int x=0;x<n;x++)
         {
            if(x>=i&&x<=j) continue;
            
            if(s.charAt(x)=='1') sum++;
         }
         sum+=(j-i)+1;
         System.out.print(i + " "+ j);
         return sum;
    }
}