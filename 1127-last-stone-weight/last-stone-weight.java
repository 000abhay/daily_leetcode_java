class Solution {
    public int lastStoneWeight(int[] stones) {
     //  if(stones.length==1) return stones[0];

        PriorityQueue<Integer> q= new PriorityQueue<>(Collections.reverseOrder());
       int ans=0;

        for(int x:stones)
        {
            q.offer(x);
            
        }
        while(!q.isEmpty())
        {
            if(q.size()==1) return q.poll();

            int a=q.poll();
            
            
            int b=q.poll();

            if(a==b) continue;

            q.offer(a-b);
           
        }
        return ans;
    }
}