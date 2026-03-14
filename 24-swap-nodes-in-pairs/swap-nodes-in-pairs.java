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
    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode p1=head,p2=head.next;
        ListNode dummy = new ListNode(0);
        dummy.next=head;
        ListNode prev=dummy;

        while(p2!=null)
        {
            ListNode temp=prev.next;
            prev.next=p2;
            p1.next=p2.next;
            p2.next=temp;
           
           prev=p1;
           if(p1.next==null||p1.next.next==null) break;
           p2=p1.next.next;
           p1=p1.next;


        }
        return dummy.next;
    }
}