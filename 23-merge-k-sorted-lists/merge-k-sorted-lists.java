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

    public  ListNode  fun( ListNode head,int x)
    {
         ListNode temp=new ListNode(x);
         ListNode save=head,prev=null;
         if(head==null) return temp;

         while(head!=null&&head.val<x) 
         {
            prev=head;
             head=head.next;
        
         }
         //FRONT UPDATE
         if(prev==null)
         {
            temp.next=head;
        return temp;

         }
         else
         {
            if(head==null)
            {
                 prev.next=temp;
            }
            else
            {
            prev.next=temp;
            temp.next=head;
         }
         }
         
         
         return save;


    }
    public ListNode mergeKLists(ListNode[] lists) {
        int n=lists.length;
        ListNode ans=null;
       
       for(int i=0;i<n;i++)
       {
      
          for(ListNode node=lists[i];node!=null;node=node.next)
          {
             ans= fun(ans,node.val);
             
          }
       }
       return ans ;
    }
}