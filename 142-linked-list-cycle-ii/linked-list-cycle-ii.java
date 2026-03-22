/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
           if(head==null||head.next==null) return null;
        
        ListNode fast=head,slow=head,temp=head;

        while(fast!=null&&fast.next!=null)
        {
           slow=slow.next;
           fast=fast.next.next;
           
             if (slow == fast) {
            // Step 2: find entry
            slow = head;

            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }

            return slow; // start of cycle

           }
          // temp=slow;
        }
        return  null;
    }
}