class Solution {
    public int[] resultArray(int[] nums) {
        int n=nums.length;
        int[]res= new int[n];
        List<Integer>temp1,temp2;
        temp1=new ArrayList<>();
        temp2=new ArrayList<>();
        temp1.add(nums[0]);
        temp2.add(nums[1]);

        for(int i=2;i<n;i++)
        {
         int x=temp1.get(temp1.size()-1);
         int y=temp2.get(temp2.size()-1);
         if(x>y) temp1.add(nums[i]);
         else temp2.add(nums[i]);

        }
        int index=0;
        for(int e:temp1) res[index++]=e;

        for(int e:temp2) res[index++]=e;


         return res;
    }
}