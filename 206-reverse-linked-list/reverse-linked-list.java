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
    ListNode x;
    ListNode fun(ListNode head)
    {
        if(head.next==null)
        {
            x=head;
             return head;
        }
        ListNode temp=fun(head.next);
      temp.next=head;
       return head;
    }
    public ListNode reverseList(ListNode head) {
        if(head==null)  return head;
          ListNode tail=fun(head);
          tail.next=null;
         return x;
    }
}