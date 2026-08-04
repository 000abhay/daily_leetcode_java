class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);
        List<Integer>ans=new ArrayList<>();
        int n=nums.length;
        int x=nums[0]+1;
        for(int i=1;i<n;i++)
        {
            while(nums[i]!=x)
            {
                ans.add(x);
                x++;
            }
            x++;
        }

        return ans;
    }
}