class Solution {
        List<List<Integer>>adj, ans;
        int []low,dis;
        boolean [] vis;

        void dfs(int node, int parent, int timer)
        {
            vis[node]=true;
            
            low[node]=dis[node]=timer;

            for(int x:adj.get(node))
            {
                if(x==parent) continue;

                if(!vis[x])
                {
                    dfs(x,node,timer+1);
                    low[node]=Math.min(low[node],low[x]);

                    if(low[x]>dis[node])
                    {
                        List<Integer>temp= new ArrayList<>();
                        temp.add(x);
                        temp.add(node);
                        ans.add(new ArrayList<>(temp));
                      

                    }
                }
                else{
                    low[node]=Math.min(low[node],dis[x]);
                }
            }

        }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> con) {
        adj= new  ArrayList<>();
        ans= new ArrayList<>();
        low= new int[n];
        dis= new int[n];
     vis= new boolean[n];

     for(int i=0;i<n;i++) adj.add(new ArrayList<>());

     for(List<Integer>x:con)
     {
        int U=x.get(0);
        int V=x.get(1);

        adj.get(U).add(V);
        adj.get(V).add(U);

     }

     for(int i=0;i<n;i++)
     {
         if(!vis[i])
         {
            dfs(i,-1,0);
         }
     }

   return ans;
    }
}