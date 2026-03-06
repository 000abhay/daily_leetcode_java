class Solution {
    public boolean checkOnesSegment(String s) {
        int l=s.length();
        boolean b1,b2=false;
        if(s.charAt(0)=='1') 
        {b1=true; b2=true;
        }
        else b1=false;
       
        for(int i=1;i<l;i++)
        {
            if(b2&&s.charAt(i)=='1'&&!b1)
            {
                return false;
            }
             if(!b1&&s.charAt(i)=='1')
             {
                b2=true;
               b1=true;
             }
             else if(b1&&s.charAt(i)=='0')
             {
                b1=false;
             }


        }
        return true;
    }
}