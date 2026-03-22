/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null) return null;
         Node x=null;
         for(Node i=head;i!=null;i=i.next.next)
         {
            x=new Node(i.val);
            //Node save=
            x.next=i.next;
            i.next=x;
         }

         
          for(Node i=head;i!=null;i=i.next.next)
          {
          if (i.random != null) i.next.random = i.random.next;
          else  i.next.random = null;
          }


        //   Node h2=null,temp=null,temp2=null;
        //   x=null;
         Node curr = head;
Node h2 = head.next;

while (curr != null) {
    Node copy = curr.next;

    curr.next = copy.next;   // restore original

    if (copy.next != null)
        copy.next = copy.next.next;  // fix copy list

    curr = curr.next;
}

        return h2;
    }
}