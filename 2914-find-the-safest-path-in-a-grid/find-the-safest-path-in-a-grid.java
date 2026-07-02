class Pair{
    int a,b;
     Pair(int a, int b)
     {
        this.a=a;
        this.b=b;
     }
}

class Solution {

    int [][] dir={
        {0,1},
        {1,0},
        {0,-1},
        {-1,0}
    };
  boolean [][]vis;
    boolean dfs(List<List<Integer>>grid, int S,int i,int j)
    {
        
        int N=grid.size(),C=grid.get(0).size();
        if(i==N-1&&j==C-1)
        {
            return true;
        }
        vis[i][j]=true;
        boolean b1=false;
        for(int[]x:dir)
        {
             int ix=i+x[0];
             int jc=j+x[1];

             if(ix>=0&&ix<N&&jc>=0&&jc<C&&grid.get(ix).get(jc)>=S&&!vis[ix][jc])
             {
                if(dfs(grid,S,ix,jc)){
                    b1=true;
                }
                  
             }
           
        }
         //vis[i][j]=false;
          return b1; 

    }
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        Queue<Pair>q= new LinkedList<>();
        int NR=grid.size();
        int NC=grid.get(0).size();
        for(int i=0;i<NR;i++)
        {
            for(int j=0;j<NC;j++)
            {
                if(grid.get(i).get(j)==1)
                {
                     q.offer(new Pair(i,j));
                     grid.get(i).set(j,0);
                }
                else grid.get(i).set(j,-1);

                

            }
        }

        while(!q.isEmpty())
        {
            int n=q.size();
             while(n>0)
             {
               Pair node=q.poll();
            for(int[]x:dir)
            {
                int nr=node.a+x[0];
                int nc=node.b+x[1];
                if(nr>=0&&nr<NR&&nc>=0&&nc<NC)
                {
                    if(grid.get(nr).get(nc)==-1)
                    {
                          int sum=grid.get(node.a).get(node.b)+1;
                          grid.get(nr).set(nc,sum);
                          q.offer(new Pair(nr,nc));
                    }
                }
                
            }
            n--;
             }


        }
        int l=0;
        int r;
        if(NR>NC) r=NR;
        else r=NC;
  int ans=0;
        while(l<=r)
        {
        vis= new boolean [NR][NC];
            System.out.print("asd");
          int mid =l+(r-l)/2;
           if(grid.get(0).get(0) >= mid &&dfs(grid,mid,0,0))
           {
              ans=mid;
              l=mid+1;
           }
           else r=mid-1;
        }
         return ans;
    }
}