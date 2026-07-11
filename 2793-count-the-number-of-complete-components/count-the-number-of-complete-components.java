class Solution {
    HashMap<Integer,List<Integer>>adj;
    boolean []vis;

    int []dfs(int node)
    {
        int [] ret= new int[2];
           vis[node]=true;

           ret[0]+=1;

           List<Integer>list=adj.get(node);

           if(list==null) return ret;

           ret[1]+=list.size();

           for(int x:list)
           {
              if(vis[x]) continue;
    int []temp=dfs(x);
       ret[0]+=temp[0];
       ret[1]+=temp[1];

           }
           return ret;

    }
    public int countCompleteComponents(int n, int[][] edges) {
        adj= new HashMap<>();
        for(int[]x:edges)
        {
            if(!adj.containsKey(x[0])) adj.put(x[0],new ArrayList<>());
            if(!adj.containsKey(x[1])) adj.put(x[1], new ArrayList<>());

            adj.get(x[0]).add(x[1]);
            adj.get(x[1]).add(x[0]);

        }
   vis= new boolean[n];

   int ans=0;
   for(int i=0;i<n;i++)
   {
      if(!vis[i]) 
      {
        int temp[]=dfs(i);
        if(temp[0]*(temp[0]-1)==temp[1]|| temp[0]==1) ans++;
      }
   }

  return ans;
    }
}