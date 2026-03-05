class Solution {
    public int minOperations(String s) {
        int l=s.length();
        int a=0;int b=0;
       byte b1=0;
        for(int i=0;i<l;i++)
        {
            if(b1!=(s.charAt(i)-'0')) a++;
             else b++;


            b1=(byte)(b1^1);
           
        }
        // for()
        // {

        // }
        return Math.min(a,b);
    }
}