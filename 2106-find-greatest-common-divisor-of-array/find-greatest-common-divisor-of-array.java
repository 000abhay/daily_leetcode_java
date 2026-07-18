class Solution {
    int gcd(int a,int b)
    {
        if(b==0) return a;
         return gcd(b,a%b);
    }
    public int findGCD(int[] nums) {
        int max=Arrays.stream(nums).max().getAsInt();
        int min=Arrays.stream(nums).min().getAsInt();
         return gcd(max,min);
    }
}