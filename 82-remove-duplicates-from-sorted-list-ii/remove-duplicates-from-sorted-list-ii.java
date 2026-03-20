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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next=head;
        ListNode prev=dummy,temp;
        Boolean b1;
        if(head==null||head.next==null) return head;
        // if(head.val==head.next.val) b1=true;
        // else b1=false;
        while(head!=null&&head.next!=null)
        {
            if(head.val!=head.next.val)
            {
                prev=head;
                head=head.next;
                b1=false;
               
            }
            else
            {
               while(head!=null&&head.next!=null&&head.val==head.next.val)
               {

                head=head.next;
               }
                 b1=true;
            }
            if(b1==true) 
            {
                prev.next=head.next;
                 head=head.next;
            }

        }
        
        
        
        return dummy.next;
    }
}