class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
         int n=grid.length;
         int m=grid[0].length;
          
          int [][]  temp= new int[n][m];
         List<List<Integer>>  ans= new ArrayList<>();
         for(int i=0;i<n;i++)
         {
            ans.add(new ArrayList<>());
            for(int j=0;j<m;j++)
            {
                int ix=(i+((j+k)/m))%n;
                int jx=(j+k)%m;
                System.out.println("row " + ix + " coloum " + jx + " == " + grid[i][j]);
                temp[ix][jx]=grid[i][j];
            }
         }

            for(int i=0;i<n;i++)
            {
                for(int j=0;j<m;j++)
                {
                    ans.get(i).add(temp[i][j]);
                }
            }
         return ans;
    }
}