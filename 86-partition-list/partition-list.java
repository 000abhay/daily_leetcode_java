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
    public ListNode partition(ListNode head, int x) {
        if(head==null||head.next==null) return head;
        ListNode ah=null,at=null,bh=null,bt=null;
        for( ;head!=null;head=head.next)
        {
            ListNode temp= new ListNode (head.val);
             if(head.val<x)
             {
                if(ah==null) 
                {
                    ah=temp;
                    at=ah;
                
                
                }else 
                {  at.next=temp;
                   at=temp;
                   
                }
             
             }
             else
             {
                if(bh==null) 
                {
                    bh=temp;
                    bt=bh;
                
                
                }else 
                {  bt.next=temp;
                   bt=temp;
                   
                }

             }
        }
        if(at==null&& bt!=null) return bh;
        if(at!=null&&bt==null) return ah;
         
         at.next=bh;
          return ah;
        
    }
}