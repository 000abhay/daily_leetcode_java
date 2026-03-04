class Triple
{
    int a,b;
    boolean b1;
    Triple( int a,int b)
    {
        this.a=a;
        this.b=b;
        b1=true;
    }
}

class Solution {
    public int numSpecial(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        
        List<Triple>adj=new ArrayList<>();

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(mat[i][j]==1)
                {
                   adj.add(new Triple(i,j));
                }
            }
        }
        Map<Integer,Integer>first=new HashMap<>();
        Map<Integer,Integer>second=new HashMap<>();

        int l=adj.size();
        for(int i=0;i<l;i++)
        {
            Triple t=adj.get(i);
            if(first.containsKey(t.a))
            {
                t.b1=false;
                adj.get(first.get(t.a)).b1=false;
            }
            else
            {
                first.put(t.a,i);
            }

            if(second.containsKey(t.b))
            {
                t.b1=false;
                adj.get(second.get(t.b)).b1=false;
            }
            else
            {
                second.put(t.b,i);
            }
        }
        int count=0;
        for(Triple x:adj)
        {
            if(x.b1) count++;
            
        }
        return count;
    }
}