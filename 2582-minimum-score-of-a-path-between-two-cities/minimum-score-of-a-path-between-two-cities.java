class Solution {
    int ans;
    boolean b1=false;

    void dfs(List<List<int[]>>adj,boolean[]vis, int node,int n)
    {
        if(node==n) 
        {
            b1=true;
        }
        vis[node]=true;

        for(int []x:adj.get(node))
        {
            int V=x[0];
            int W=x[1];
             ans=Math.min(W,ans);
            if(!vis[V])
            {
                dfs(adj,vis,V,n);
            }

        }
    }
    public int minScore(int n, int[][] roads) {
        List<List<int[]>>adj= new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());

        for(int[]x:roads)
        {
            int U=x[0]-1;
            int V=x[1]-1;
            adj.get(U).add(new int[]{V,x[2]});
            adj.get(V).add(new int[]{U,x[2]});

        }
       boolean[] vis= new boolean[n];
        for(int i=0;i<n;i++)
        {
             if(b1) break;

            if(!vis[i])
            {
                ans=Integer.MAX_VALUE;
                dfs(adj,vis,i,n-1);

            }

        }
        return ans;
    }
}