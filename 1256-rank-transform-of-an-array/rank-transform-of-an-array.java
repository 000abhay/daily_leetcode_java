class Solution {
    public int[] arrayRankTransform(int[] arr) {
       int []C=arr.clone();
       Arrays.sort(C);
       int n=arr.length;
       int [] ans= new int[n];
       Map<Integer,Integer>adj= new HashMap<>();
       int count=1;
     for(int i=0;i<n;i++)
     {
          if(!adj.containsKey(C[i]))
          {
             adj.put(C[i],count);
             count++;
          }

     }
     for(int i=0;i<n;i++)
     {
        ans[i]=adj.get(arr[i]);
     }

     
   return ans ;
    
    }
}