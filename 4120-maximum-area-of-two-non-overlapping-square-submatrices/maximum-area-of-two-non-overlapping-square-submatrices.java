class Solution {
    int [][]pre;
  int r,c;
//  boolean check(int i, int j, int x,
//               int r1, int r2, int c1, int c2) {

//     int newTop = i - x + 1;
//     int newBottom = i;
//     int newLeft = j - x + 1;
//     int newRight = j;

//     boolean overlap =
//         r1 <= newBottom &&
//         r2 >= newTop &&
//         c1 <= newRight &&
//         c2 >= newLeft;

//     return !overlap;
// }
    boolean fun(int x)
    {
      int count=0;
       // int r1=-1,r2=-1,c1=-1,c2=-1;

        int minTop = Integer.MAX_VALUE;
    int maxTop = Integer.MIN_VALUE;
    int minLeft = Integer.MAX_VALUE;
    int maxLeft = Integer.MIN_VALUE;
           for(int i=x;i<=r;i++)
           {
             for(int j=x;j<=c;j++)
             {
                int sum=pre[i][j]
                      -pre[i-x][j]
                      -pre[i][j-x]
                      +pre[i-x][j-x];
                if(sum==x*x)
                {
                    count++;
                  int top = i - x + 1;
                int left = j - x + 1;

                minTop = Math.min(minTop, top);
                maxTop = Math.max(maxTop, top);

                minLeft = Math.min(minLeft, left);
                maxLeft = Math.max(maxLeft, left);
                }
             }
           }
            if(count<2) return false;
            return maxTop - minTop >= x ||
           maxLeft - minLeft >= x;
    }
    public int maxArea(int[][] mat) {
        r=mat.length;
        c=mat[0].length;
        pre= new int[r+1][c+1];

       // pre[0][0]=mat[0][0];
      for(int i=1;i<=r;i++)
      {
        for(int j=1;j<=c;j++)
        {
            pre[i][j]=mat[i-1][j-1]
                   +pre[i-1][j]
                   +pre[i][j-1]
                   -pre[i-1][j-1];
        }
      }
    int low=1;
    int high=(r<c)?r:c;
    int sum=0;
    while(low<=high)
    {
        int mid=low + (high-low)/2;

        if(fun(mid)) 
        {
            sum=mid;
            low=mid+1;
        }
        else high=mid-1;
        
    }

      return sum*sum;
    }
}