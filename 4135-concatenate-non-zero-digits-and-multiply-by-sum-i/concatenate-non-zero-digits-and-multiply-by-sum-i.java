class Solution {
    public long sumAndMultiply(int n) {
        int store=0,sum=0;
        while(n>0)
        {
            int x=n%10;
            if(x!=0){
            sum+=x;
            store=(store*10)+x;
            }
            n/=10;
        }
        String s=Integer.toString(store);
        store=Integer.parseInt(new StringBuilder(s).reverse().toString());
        return (long) store*sum;

    }
}