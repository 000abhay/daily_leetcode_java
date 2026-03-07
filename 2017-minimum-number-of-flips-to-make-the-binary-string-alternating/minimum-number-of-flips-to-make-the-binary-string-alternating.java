class Solution {
    public int minFlips(String s) {
    //   int k=s.length();
    //   String str=s+s;
    //   int l=str.length();
    //   int left=0,right=0,sum=Integer.MAX_VALUE,temp=0,p2=0,pt1=0,pt2=0; 
    //   while(right<l)
    //   {
    //    if(right%2==0&&str.charAt(right)=='0') pt1++;
    //    else if(right%2!=0&&str.charAt(right)=='1') pt1++;
    //    else if(right%2==0&&str.charAt(right)=='1') pt2++;
    //    else if(right%2!=0&&str.charAt(right)=='0') pt2++;

    //    else if(right>=k) 
    //    {
    //     if(left%2==0&&str.charAt(left)=='0') pt1--;
    //    else if(left%2!=0&&str.charAt(left)=='1') pt1--;
    //    else if(left%2==0&&str.charAt(left)=='1') pt2--;
    //    else if(left%2!=0&&str.charAt(left)=='0') pt2--;

    //     left++;
    //    }
    //    if((right-left)+1==k)
    //    {
    //     temp=Math.min(pt1,pt2);
    //    sum=Math.min(temp,sum);
          
    //    }
    //    right++;


    //   } 
    //   return sum; 
    int n = s.length();
        String str = s + s;

        int left = 0;
        int pt1 = 0, pt2 = 0;
        int ans = Integer.MAX_VALUE;

        for (int right = 0; right < str.length(); right++) {

            // incoming element
            if (str.charAt(right) != (right % 2 == 0 ? '0' : '1')) pt1++;
            if (str.charAt(right) != (right % 2 == 0 ? '1' : '0')) pt2++;

            // shrink window
            if (right - left + 1 > n) {

                if (str.charAt(left) != (left % 2 == 0 ? '0' : '1')) pt1--;
                if (str.charAt(left) != (left % 2 == 0 ? '1' : '0')) pt2--;

                left++;
            }

            // valid window
            if (right - left + 1 == n) {
                ans = Math.min(ans, Math.min(pt1, pt2));
            }
        }

        return ans;
    }
}