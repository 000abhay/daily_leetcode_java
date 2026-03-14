/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode>pq=new PriorityQueue<>( (a,b)-> a.val - b.val);
        for(ListNode x:lists)
        {
            if(x!=null)       pq.add(x);
       
        }

        ListNode dummy= new ListNode(0);
        ListNode current=dummy;
           while(!pq.isEmpty())
           {
            ListNode temp=pq.poll();
            current.next=temp;
            current=current.next;
            if(temp.next!=null)
            {
                pq.add(temp.next);
            }
           }
        
        return dummy.next;
    }
}