class Solution {
    public int minScore(int n, int[][] roads) {
        int[]dist= new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[0]=0;
       // int[]edge_cost= new int[n];
       // Arrays.fill(edge_cost,Integer.MAX_VALUE);
        List<List<int[]>>adj= new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        
        for(int[]x:roads)
        {
            int U=x[0]-1;
            int V=x[1]-1;
            adj.get(U).add(new int[]{V,x[2]});
            adj.get(V).add(new int[]{U,x[2]});
        }
        Queue<int[]>q=new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        boolean[]vis=new boolean[n];
        boolean b1=false;
  int S=-1;
        for(int i=0;i<n;i++)
{
    if(b1) break;
     S=Integer.MAX_VALUE;
       if(!vis[i])
    {
        vis[i]=true;
        q.offer(new int[]{0,i});
        while(!q.isEmpty())
        {
            int []node=q.poll();
           int W=node[0];
           int U=node[1];
          // int min_edge=node[2];
           
          // if(dist[U]<W) continue;

           for(int x[]:adj.get(U))
           {
                int V=x[0];
               if(V==n-1) b1=true;
                vis[V]=true;
                int weight=x[1];
               if(weight<S)S=weight;
               // int min=(weight<min_edge)?weight:min_edge;

                if(weight+W<dist[V])
                {
                   
                // edge_cost[V]=min;
                 dist[V]=weight+W;
                  
                    q.offer(new int[]{dist[V],V});
                }


           }



        }
    }
}
        return S;

    }
}