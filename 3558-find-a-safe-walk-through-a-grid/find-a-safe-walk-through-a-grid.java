class Pair{
    int a,b;
    Pair(int a, int b)
    {
        this.a=a;
        this.b=b;
    }
}

class Solution {

    int [][]Dir={
        {0,1},
        {1,0},
        {0,-1},
        {-1,0}
    };
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        Deque<Pair> dq= new ArrayDeque<>();
        int NR=grid.size();
        int NC=grid.get(0).size();

        dq.offerFirst( new Pair(0,0));

         int [][]clone = new int[NR][NC];
         for(int i=0;i<NR;i++) Arrays.fill(clone[i],Integer.MAX_VALUE);
         clone[0][0]=grid.get(0).get(0);
         

         while(!dq.isEmpty())
         {
            //int n=dq.size();
            Pair node=dq.pollFirst();
            // if(grid.get(node.a).get(node.b)==1)
            // {
            //     health--;
            //     if(health<0) return false ;
            // }
            // grid.get(node.a).set(node.b,-1);


            // while(n>=0)
            // {
                for(int []dir:Dir)
                {
                    int nr=node.a+dir[0];
                    int nc=node.b+dir[1];

                    if(nr>=0&&nr<NR&&nc>=0&&nc<NC)
                     
                    {

                        int weight = grid.get(nr).get(nc);
                         if(clone[node.a][node.b] != Integer.MAX_VALUE&&clone[node.a][node.b]+weight<clone[nr][nc])
                         {
                        
                            clone[nr][nc]=clone[node.a][node.b]+ weight;
                              if(grid.get(nr).get(nc)==0) dq.offerFirst( new Pair(nr,nc));
                              else dq.offerLast(new Pair(nr,nc));


                         }

                    }

               }

                
                

            //    n--;
            // }
         }

         health-=clone[NR-1][NC-1];
         System.out.print(health);
         if(health<=0) return false ;

         return true;
    }
}