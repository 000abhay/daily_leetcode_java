class Solution {
    public int maximumLengthSubstring(String s) {
        int n=s.length();
        int sum=0;
        int low=0,high=0;
        Map<Character,Integer>feq= new HashMap<>();
         while(high<n)
         {
              char x=s.charAt(high);
               feq.put(x,feq.getOrDefault(x,0)+1);

               while(feq.get(x)>2)
               {
                 char y=s.charAt(low);
                 feq.put(y,feq.get(y)-1);
                 low++;
               }

               sum=Math.max(sum,high-low+1);

              high++;
         }
        return sum;
    }
}