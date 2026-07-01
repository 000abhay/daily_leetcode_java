class Solution {
      static class Fenwick {
        int[] bit;

        Fenwick(int n) {
            bit = new int[n + 1];
        }

        void update(int idx, int val) {
            while (idx < bit.length) {
                bit[idx] += val;
                idx += idx & -idx;
            }
        }

        int query(int idx) {
            int sum = 0;
            while (idx > 0) {
                sum += bit[idx];
                idx -= idx & -idx;
            }
            return sum;
        }
    }

    public static long countPairs(int[] pre) {
        int n = pre.length;

        // Coordinate Compression
        int[] sorted = pre.clone();
        Arrays.sort(sorted);

        Map<Integer, Integer> rank = new HashMap<>();
        int r = 1;
        for (int x : sorted) {
            if (!rank.containsKey(x))
                rank.put(x, r++);
        }

        Fenwick ft = new Fenwick(r);

        long count = 0;

        for (int x : pre) {
            int idx = rank.get(x);

            // Number of previous values < current value
            count += ft.query(idx - 1);

            // Insert current value
            ft.update(idx, 1);
        }

        return count;
    }
    public int countMajoritySubarrays(int[] nums, int target) {
          int l=nums.length;
          for(int i=0;i<l;i++)
          {
            if(nums[i]==target) nums[i]=1;
            else nums[i]=-1;
          }

          int []pre= new int[l+1];
          pre[0]=0;
          for(int i=1;i<l+1;i++)   pre[i]=nums[i-1]+pre[i-1];
           

        //    int count=0;
        //    for(int i=0;i<l+1;i++)
        //      for(int j=i+1;j<l+1;j++)
        //      {
        //         if(pre[i]<pre[j])  count++;
            
        //      }
       

           return (int) countPairs(pre);

    }
}