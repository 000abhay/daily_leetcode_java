class Fenwick{
    int[]f1,f2;
    Map<Integer,Integer>adj=new HashMap<>();
    int maxn;
    Fenwick(int[]temp)
    {
         int count=1;
        for(int i=0;i<temp.length;i++)
        {
            if(!adj.containsKey(temp[i]))
            {
                adj.put(temp[i],count);
                count++;
            }
        }
        maxn=count;
        f1= new int[maxn];
        f2=new int[maxn];
       


    }
    void update_1(int x)
    {
        int i=adj.get(x);
        while(i<maxn)
        {
            f1[i]++;
            i+=i&-i;
        }
    }

    void update_2(int x)
    {
        int i=adj.get(x);
        while(i<maxn)
        {

            f2[i]++;
            i+=i&-i;
        }
    }
     
     int query_1(int x)
     {
        int i=adj.get(x);
        int count=0;
        while(i>0)
        {
            count+=f1[i];
           i-=i&-i;
        }
        return count;
     }

     int query_2(int x)
     {
        int i=adj.get(x);
        int count=0;
        while(i>0)
        {
            count+=f2[i];
            i-=i&-i;
        }
     return count;
     }
     
   

    
}

class Solution {


    public int[] resultArray(int[] nums) {
        int n=nums.length;
        int []temp=nums.clone();
        Arrays.sort(temp);

       
    Fenwick fen= new Fenwick(temp);
    
   List<Integer>temp1,temp2;
   temp1= new ArrayList<>();
    temp2= new ArrayList<>();

    temp1.add(nums[0]);
    temp2.add(nums[1]);
    fen.update_1(nums[0]);
    fen.update_2(nums[1]);

    for(int i=2;i<n;i++)
   { 
    int x=fen.query_1(temp[n-1])-fen.query_1(nums[i]);
    int y=fen.query_2(temp[n-1])-fen.query_2(nums[i]);

      if(x>y)
      {
           fen.update_1(nums[i]);
           temp1.add(nums[i]);
      }
      else if(y>x)
      {
       fen.update_2(nums[i]);
        temp2.add(nums[i]);
      }
      else{
        
        if(temp1.size()<temp2.size())
        {
            fen.update_1(nums[i]);
            temp1.add(nums[i]);
        }
        else if(temp1.size()>temp2.size())
        {
          fen.update_2(nums[i]);
           temp2.add(nums[i]);
        }
        else{
          fen.update_1(nums[i]);
          temp1.add(nums[i]);
        }

      }


   }
   int[] res=new int[n];
   int index=0;
   for(int e:temp1)res[index++]=e;

   for(int e:temp2)res[index++]=e;
   



     return res;
    }
}