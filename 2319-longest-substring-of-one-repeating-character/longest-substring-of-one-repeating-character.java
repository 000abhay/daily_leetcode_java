class SegmentTree{
    
    static class Node{
        int pref,
            sufix,
            best,
            len;
            char first,last;
        
        Node(char value)
        {
            pref=1;
            sufix=1;
            best=1;
            len=1;
            first=value;
            last=value;

        }
        Node(){}


       

    }
   int n;
   Node [] tree;

   SegmentTree(String arr)
   {
     n=arr.length();
     tree= new Node[4*n];

     build(1,0,n-1,arr);
   }




 void build(int node,int l,int r,String arr)
 {

    if(l==r)
    {
        tree[node]= new Node(arr.charAt(l));
         return;
    }

      int mid= l + (r-l)/2;

      build(2*node,l,mid,arr);
      build(2*node+1,mid+1,r,arr);

      tree[node]=merge(tree[2*node],tree[2*node+1]);

 }

Node merge(Node left,Node right)
{
    Node res= new Node();

    res.len=left.len+right.len;
    res.first=left.first;
    res.last=right.last;
    res.pref=left.pref;
    res.sufix=right.sufix;

    if(left.len==left.pref&&left.last==right.first)
    {
        res.pref=left.len+right.pref;
    }    

    if(right.len==right.sufix&&left.last==right.first)
    {
        res.sufix=right.len+left.sufix;
    }

    res.best=Math.max(left.best,right.best);

    if(left.last==right.first)
    {
        res.best=Math.max(res.best,left.sufix+right.pref);
    }
     return res;

}

int update(int pos,char value)
{
    Update(1,0,n-1, pos,value);
      return query(0,n-1);
}

void Update(int node,int l,int r,int pos,char value)
{
    if(l==r)
    {
        tree[node]=new Node(value);
        return ;
    }

    int mid=l+ (r-l)/2;
   
    if(pos<=mid)
    {

      Update(2*node,l,mid,pos,value);
    }
 else{
    Update(2*node+1,mid+1,r,pos,value);

 }

 tree[node]=merge(tree[2*node],tree[2*node+1]);


}

int query(int left,int right)
{
    return Query(1,0,n-1,left,right).best;
}

Node Query(int node,int l,int r,int ql,int qr)
{
    if(l>=ql&&r<=qr)    return tree[node];

    int mid=l+(r-l)/2;

    if(qr<=mid)
    {
        return Query(2*node,l,mid,ql,qr);
    }
    if(ql>mid)
    {
        return Query(2*node+1,mid+1,r,ql,qr);
    }

    Node left=Query(2*node,l,mid,ql,qr);
    Node right=Query(2*node+1,mid+1,r,ql,qr);

      return merge(left,right);
}

}


class Solution {
    public int[] longestRepeating(String s, String qc, int[] qi) {
      int n2=qi.length;
       int []ans= new int[n2];
       SegmentTree SG= new SegmentTree(s);

       for(int i=0;i<n2;i++)
       {
         ans[i]=SG.update(qi[i],qc.charAt(i));
       }
       
       return ans;
    }
}