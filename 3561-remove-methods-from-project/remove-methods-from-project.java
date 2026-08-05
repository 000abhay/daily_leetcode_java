class Solution {
  
     void dfs(List<List<Integer>>adj,int []indgree,boolean [] vis,int k,Set<Integer>temp)
     {
        vis[k]=true;
        temp.add(k);
        for(int node:adj.get(k))
        {
            indgree[node]--;
            if(!vis[node])
            {
                dfs(adj,indgree,vis,node,temp);
            }
        }
     }
    public List<Integer> remainingMethods(int n, int k, int[][] invo) {
        List<List<Integer>>adj= new ArrayList<>();
        List<Integer>ans= new ArrayList<>();
         for(int i=0;i<n;i++) adj.add(new ArrayList<>());

         int []indgree= new int[n];
         Set<Integer>temp= new HashSet<>();
         for(int x[]:invo)
         {
            adj.get(x[0]).add(x[1]);
            indgree[x[1]]++;
         }

         dfs(adj,indgree,new boolean[n],k,temp);
          for(int x:temp)
          {
             if(indgree[x]>0)
             {
                for(int i=0;i<n;i++) ans.add(i);

                 return ans;
             }
          }
         
         for(int i=0;i<n;i++)
         {
            if(!temp.contains(i))
            {
                ans.add(i);
            }
         }
        return ans;
    }
}