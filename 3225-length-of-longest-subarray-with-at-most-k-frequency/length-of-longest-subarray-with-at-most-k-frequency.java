class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n=nums.length;
        int  low=0,high=0;
        int sum=0;
        Map<Integer,Integer>feq= new HashMap<>();
        while(high<n)
        {
            int x=nums[high];
            feq.put(x,feq.getOrDefault(x,0)+1);

            while(feq.get(x)>k)
            {
                int y=nums[low];
                feq.put(y,feq.get(y)-1);
                low++;
            }

            sum=Math.max(sum,(high-low+1));
           // System.out.println(sum);
            high++;
           
        }
        return sum;
    }
}