class Solution {

    ListNode fun(ListNode prev, ListNode start, int k)
    {
        ListNode then = start.next;

        for(int i = 0; i < k - 1; i++)
        {
            start.next = then.next;
            then.next = prev.next;
            prev.next = then;
            then = start.next;
        }

        return start; // return tail of reversed group
    }

    public ListNode reverseKGroup(ListNode head, int k) {

        if(head == null || k == 1) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        int n = 0;

        for(ListNode i = head; i != null; i = i.next)
            n++;

        int groups = n / k;

        ListNode prev = dummy;
        ListNode start = head;

        while(groups > 0)
        {
            start = fun(prev, start, k); // start becomes tail

            prev = start;
            start = start.next;

            groups--;
        }

        return dummy.next;
    }
}