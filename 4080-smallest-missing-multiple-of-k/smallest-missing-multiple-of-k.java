class Solution {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer>adj= new HashSet<>();

        for(int x:nums) adj.add(x);
        int x=k;
        while(true)
        {
            //System.out.println(x);
            if(!adj.contains(x)) break;

            x+=k;
        }
        return x;
    }
}