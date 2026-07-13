class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        int tempz=(int)Math.log10(low)+1;
        int num=12;
        int count=2;
        while(count<tempz)
        {
            num=(num*10)+(count+1);
            count++;
        }
         int zero=(int)Math.log10(num)+1;
         int x=0;
         for(int i=0;i<zero;i++) x=((x*10)+1);
        
         List<Integer>ans=new ArrayList<>();
       //  System.out.println(x);
          while(num<=high)
          {
            if(num>=low) ans.add(num);
             if(num%10==9)
             {
                num+=((x*(zero+1))+1);
               zero++;
               x=(x*10)+1;
             }
             else{
 //System.out.println(x);
                num+=x;
             }
          }
          return ans;
    }
}