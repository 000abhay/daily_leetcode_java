/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root==null) return root;
        Deque<Node>q= new ArrayDeque<>();
        q.addLast(root);
        while(!q.isEmpty())
        {
            int n=q.size();
             Node temp=null;
              while(n>0)
              {
                 Node node=q.pollFirst();
                 if(temp!=null)
                 {
                   temp.next=node;
                 }
                 temp=node;
            if(node.left!=null)     q.addLast(node.left);
              if(node.right!=null)   q.addLast(node.right);
                 
                n--;
              }
            if(temp!=null)  temp.next=null;

        }
        return root;
        
    }
}