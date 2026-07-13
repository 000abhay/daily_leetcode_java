class Solution {
    List<List<Integer>>ans;
    void dfs(int []can ,int x,int i,int n,List<Integer>temp)
    {
        if(i>=n) return ;
        if(ans.size()>=150) return;

       if (x == 0) {
    ans.add(new ArrayList<>(temp));
    return;
     }

     if (x < 0)  return;
     
        temp.add(can[i]);
        dfs(can,x-can[i],i,n,temp);
        temp.remove(temp.size()-1);
        dfs(can,x,i+1,n,temp);

    }
    public List<List<Integer>> combinationSum(int[] can, int target) {
          int n=can.length;
          ans=new ArrayList<>();
          dfs(can,target,0,n,new ArrayList<>());
        
        return ans;
    }
}