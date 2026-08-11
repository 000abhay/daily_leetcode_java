class Solution {
    public int missingInteger(int[] nums) {
        Set<Integer>adj= new HashSet<>();
        int seq=nums[0],sum=nums[0];
        for(int x:nums)  adj.add(x);

        for(int i=1;i<nums.length;i++)
        {
           if(seq==nums[i]-1)
           {
            sum+=nums[i];
            seq++;
           }
           else break;



           
        }
        System.out.print(sum);
        while(true)
        {
            if(!adj.contains(sum))
            {
              break;
            }
            sum++;
        }
         return sum;
    }
}