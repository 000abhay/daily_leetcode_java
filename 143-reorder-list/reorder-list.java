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
   public void reorderList(ListNode head) {
    if (head == null || head.next == null) return;

    Deque<ListNode> stack = new ArrayDeque<>();

    // push all nodes
    ListNode curr = head;
    int n = 0;
    while (curr != null) {
        stack.push(curr);
        curr = curr.next;
        n++;
    }

    curr = head;

    // only process half
    for (int i = 0; i < n / 2; i++) {
        ListNode last = stack.pop();

        ListNode temp = curr.next;

        curr.next = last;
        last.next = temp;

        curr = temp;
    }

    curr.next = null; 
}
}