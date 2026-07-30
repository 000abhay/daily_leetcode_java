class Solution {
    public int minimumPushes(String word) {
        int l=word.length();
       Map<Character,Integer>freq= new HashMap<>();
      for(int i=0;i<l;i++) freq.put(word.charAt(i),freq.getOrDefault(word.charAt(i),0)+1);

      PriorityQueue<Map.Entry<Character,Integer>> pq= new PriorityQueue<>((a,b)->b.getValue().compareTo(a.getValue()));
         pq.addAll(freq.entrySet());
      int sum=0,count=1,a=0;
     while(!pq.isEmpty())
     {
         Map.Entry<Character,Integer> temp= pq.poll();
         int x=temp.getValue();

         a++;

         if(a%9==0)
       {
        a=1;
        count++;
        }

        sum+=(count*x);
         


     }


     return sum;

    }
}