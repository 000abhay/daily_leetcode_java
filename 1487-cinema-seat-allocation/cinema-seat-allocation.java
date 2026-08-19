class Solution {
    public int maxNumberOfFamilies(int n, int[][] res) {
        int a1=2,b1=5,
           a2=4,b2=7,
           a3=6,b3=9;
           Arrays.sort(res,(a,b)->{
              if(a!=b) return Integer.compare(a[0],b[0]);
              else return  Integer.compare(a[1],b[1]);
           });
           int count=0;
         int r=res.length;
        //  for(int i=0;i<r;i++)
        //  {
        //     System.out.println(res[i][0]+ " :" + res[i][1]);
        //  }
        Set<Integer>vis= new HashSet<>();
         for(int i=0;i<r;i++)
         {
            vis.add(res[i][0]);
            boolean B1=false,
                    B2=false,
                    B3=false;
            int x;
            while(i<r-1&&res[i][0]==res[i+1][0])
            {
                 x=res[i][1];
              if(a1<=x&&x<=b1)B1=true;
              if(a2<=x&&x<=b2) B2=true;
              if(a3<=x&&x<=b3) B3=true;
              i++;
            }
                x=res[i][1];
             if(a1<=x&&x<=b1)B1=true;
              if(a2<=x&&x<=b2) B2=true;
              if(a3<=x&&x<=b3) B3=true;

           if(!B1)
           {
              count++;
              if(!B3) count++;
           }

           else if(!B2) count++;

           else if(!B3) count++;


            


         }


        int result=n-vis.size();
        count+=result*2;



           return count;
    }
}