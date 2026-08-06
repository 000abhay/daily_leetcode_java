class Solution {
     int[][]dir={{1,0},{0,1},{-1,0},{0,-1}};
     int r,c;
    boolean isReach(int[][]grid,int timer,int i,int j,boolean [][]vis)
    {
        vis[i][j]=true;

         if(i==r-1&&j==c-1) return true;

         for(int []x:dir)
         {
            int ix=i+x[0];
            int jx=j+x[1];

            if(ix>=0&&ix<r&&jx>=0&&jx<c&&grid[ix][jx]<=timer&&!vis[ix][jx])
            {
                if(isReach(grid,timer,ix,jx,vis))  return true;
            }
         }

          return false;
    }
    public int swimInWater(int[][] grid) {
      r=grid.length;
     c=grid[0].length;
     int low=Math.max(grid[r-1][c-1],grid[0][0]);

     int high=(r*c)-1;

      while(low<=high)
      {
         int mid=low + (high-low)/2;

         if(isReach(grid,mid,0,0, new boolean[r][c]))
         {
            high=mid-1;
         }
         else low=mid+1;

      }


   return low;


   

    }
}