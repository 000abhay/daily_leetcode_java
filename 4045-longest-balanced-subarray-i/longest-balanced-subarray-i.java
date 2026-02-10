class Solution {
    public int longestBalanced(int[] nums) {
        Set<Integer>arr=new HashSet<>();
        int n=nums.length;
        int sum=0,odd,even,count,temp;
        for(int i=0;i<n;i++)
        {
            
            odd=0;even=0;count=0;temp=0;
            arr.add(nums[i]);
            if ((nums[i] & 1) == 0) {
                      even++;
            } else {
                   odd++;
            }

            for(int j=i+1;j<n;j++)
            {
                if(!arr.contains(nums[j]))
                {
                    arr.add(nums[j]);
                     if ((nums[j] & 1) == 0) {
                            even++;
                     } else {
                           odd++;
                       }

                     if(odd==even)  count=odd+even;
                }
                else 
                {
                   // System.out.println("sdff");
                    temp++;
                }
                
            if((odd==even)&&(count+temp)>sum) sum=count+temp;
            }
           //System.out.println("o:" + odd + "even:"+ even + "count " + count + "temp :"+ temp);
            arr.clear();
        }
     return sum;
    }
}