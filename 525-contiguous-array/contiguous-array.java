class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer>map=new HashMap<>();
        int sum=0;
        int max_len=0;
        int n=nums.length;
        map.put(0,-1);
        for(int i=0;i<n;i++)
        {
            if(nums[i]==0) sum--;
            else sum++;
            if(map.containsKey(sum))
            {
                int temp=i-map.get(sum);
                max_len=Math.max(max_len,temp);
            }
            else
            {
                map.put(sum,i);
            }
        }
        return max_len;
    }
}