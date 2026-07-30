class Solution {
    public int minimumPushes(String word) {
         int l=word.length();
         if(l<=8) return l;
         int sum=8,count=2;
         l-=8;
         while(true)
         {
            if(l<8)
            {
                sum+=(count*l);
                break;
            }
            else
            {
                sum+=(count*8);
                l-=8;
                count++;
            }


         }

         return sum;
    }
}