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
    int getlen(ListNode head)
    {
        if(head==null) return 0;
         return 1+getlen(head.next);
    }
    public ListNode rotateRight(ListNode head, int k) {
        int n=getlen(head);
        if(n<=1) return head;
        for(int i=0;i<k%n;i++)
        {
        ListNode last_second=head;
            
            while(last_second.next.next!=null) last_second=last_second.next;
            ListNode temp= new ListNode(last_second.next.val);
            temp.next=head;
            head=temp;
            last_second.next=null;
        }
        return head;
    }
}