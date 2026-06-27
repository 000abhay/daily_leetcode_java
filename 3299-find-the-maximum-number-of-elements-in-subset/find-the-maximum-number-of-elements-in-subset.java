



  class Node 
  {
    int freq;
     boolean flag;
        Node( int freq, Boolean flag)
        {
             this.freq=freq;
             this.flag=flag;

        }
  }
class Solution {


  HashMap<Integer,Node>adj;

  int s;
    void  fun( int x)
   {
        if(adj.get(x).flag)  return ;

      if(adj.containsKey(x*x))
      {
         if(adj.get(x).freq>=2)
         {
              System.out.println(s);

            adj.get(x).flag=true;
            s+=2;
            fun(x*x);
         }

      }

   }
    public int maximumLength(int[] nums) {
            adj= new HashMap<>();
            Arrays.sort(nums);
            for(int x:nums)
            {
                if(adj.containsKey(x))
                {
                    adj.get(x).freq++;
                }
                else
                {
                    adj.put(x, new Node(1,false));
                }
            }
            int count=0;
             for( int x:nums)
             {
                 if(x==1) continue;
            
                 s=0;
                 fun(x);
             //   System.out.println(s);
                  count = (count < s) ? s : count;
                   

             }
             if(adj.containsKey(1))
             {
                int a=adj.get(1).freq;
                if(a%2==0)  a--;
                 if(a>count) return a;
            
             }
            //  if(count==0) return 0;


                return count +1;
           // return count+1;
    }
}