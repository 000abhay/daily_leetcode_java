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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    ListNode get_middle(ListNode head)
    {
        if(head==null|| head.next==null) return head;
          ListNode prev=null,slow=head,fast=head;
          while(fast!=null&&fast.next!=null)
          {
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
          }
           if( prev!=null) prev.next=null;

           return slow;

    }
    public TreeNode sortedListToBST(ListNode head) {

        if(head==null) return null;
        if(head.next==null) return  new TreeNode (head.val);

         ListNode mid= get_middle(head);
        TreeNode root = new TreeNode(mid.val);
        TreeNode left=sortedListToBST(head);
        TreeNode right=sortedListToBST(mid.next);

        root.left=left;
        root.right=right;
        return root ;
    }
}