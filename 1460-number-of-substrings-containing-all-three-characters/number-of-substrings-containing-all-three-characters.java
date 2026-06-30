class Solution {
    public int numberOfSubstrings(String s) {
        int a=-1,c=-1;
        int b=-1,count=0;
        int idx=1;
        for( char ch:s.toCharArray())
        {
              if(ch=='a')a=idx++;
              if(ch=='b')b=idx++;
              if(ch=='c') c=idx++;

                System.out.println(a + " " + b + " "+c);;

            if(a!=-1&&b!=-1&&c!=-1)
            {
                int x=Math.min(a,Math.min(b,c));
                  count+=x;

            }
            
        }
        return count ;

    }
}