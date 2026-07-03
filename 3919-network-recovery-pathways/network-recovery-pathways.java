// class Pair{
//     int u,v,cost;
//     Pair(int u,int v,int cost)
//     {
//         this.u=u;
//         this.v=v;
//         this.cost=cost;
//     }
// }
class Solution {
List<List<int[]>>adj;

     void safeInsert(List<Integer>bin, int x)
     {
        int index=Collections.binarySearch(bin,x);
        if(index<0)
        {
            index=-(index+1);
            bin.add(index,x);
        }
     }


     int N=0;
     boolean dikistra( boolean [] online , long K, int X)
     {
        int[]cost=new int[N];
        Arrays.fill(cost,Integer.MAX_VALUE);
        cost[0]=0;

        Queue<int[]>q=new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));

        q.offer(new int[]{0,0});
        while(!q.isEmpty())
        {
            int[]node=q.poll();
              int weight=node[0];
              int U=node[1];
            if(weight>cost[U]||!online[U]) continue;

            for(int[]neigh:adj.get(U))
            {
                int V=neigh[0];
                int W=neigh[1];

                if(W<X||!online[V]) continue;

                if(cost[U]+W<cost[V])
                {
                    cost[V]=cost[U]+W;
                    q.offer(new int[]{cost[V],V});
                }
            }

        }
        long c=cost[N-1];
        if(c==Integer.MAX_VALUE||c>K)  return false;
      
       return true;

     }
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
       List<Integer>bin=new ArrayList<>();
      adj= new ArrayList<>();
      N=online.length;
       for(int[]x:edges)   safeInsert(bin,x[2]);

       for(int i=0;i<N;i++)  adj.add(new ArrayList<>());
       
       for(int[]x:edges)  adj.get(x[0]).add(new int[]{x[1],x[2]});


        int l=0;
        int r=bin.size()-1;
        int ans=-1;
        while(l<=r)
        {
            int mid=l+(r-l)/2;
            int X=bin.get(mid);

            if(dikistra(online,k,X))
            {
                ans=X;
                l=mid+1;
            }
            else r=mid-1;
        }
        if(ans==-1) return -1;
  return ans;
        

    }
}