class Solution {
    public int stoneGameVI(int[] a, int[] b) {
        List<int[]>ans= new ArrayList<>();
        int n=a.length;

        for(int i=0;i<n;i++)
        {
            ans.add(new int[]{a[i],b[i]});
        }
     ans.sort((q,w)->Integer.compare(w[0]+w[1],q[0]+q[1]));
      boolean flag=true;
      int A=0,B=0;

      for(int x[]:ans)
      {

         if(flag)   A+=x[0];
         else B+=x[1];

         flag=!flag;
         
      }
        if(A<B) return -1;
        else if(A>B) return 1;
        
         return 0;
        
    }
}