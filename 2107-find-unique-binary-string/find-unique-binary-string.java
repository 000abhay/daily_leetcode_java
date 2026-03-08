class Solution {
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder str= new StringBuilder();
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            char bit=nums[i].charAt(i);
            if(bit=='0') str.append('1');
            else str.append('0');
        }
        return str.toString();
    }
}