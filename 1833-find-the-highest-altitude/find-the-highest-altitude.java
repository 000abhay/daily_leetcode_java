class Solution {
    public int largestAltitude(int[] gain) {
        int max=0,sum=0;
         int l=gain.length;
        for(int i=0;i<l;i++)
        {
            sum+=gain[i];
            if(sum>max) max=sum;
        }
        return max;
    }
}