import java.util.*;

class Solution {

    class Node {
        int count;
        char ch;

        Node(int count, char ch) {
            this.count = count;
            this.ch = ch;
        }
    }

    public String longestDiverseString(int a, int b, int c) {

        PriorityQueue<Node> pq = new PriorityQueue<>(
            (x, y) -> y.count - x.count
        );

        if (a > 0) pq.offer(new Node(a, 'a'));
        if (b > 0) pq.offer(new Node(b, 'b'));
        if (c > 0) pq.offer(new Node(c, 'c'));

        StringBuilder sb = new StringBuilder();

        while (!pq.isEmpty()) {

            Node first = pq.poll();

            int len = sb.length();

            if (len >= 2 &&
                sb.charAt(len - 1) == first.ch &&
                sb.charAt(len - 2) == first.ch) {

                if (pq.isEmpty()) {
                    break;
                }

                Node second = pq.poll();

                sb.append(second.ch);
                second.count--;

                if (second.count > 0) {
                    pq.offer(second);
                }

                pq.offer(first);

            } else {

                sb.append(first.ch);
                first.count--;

                if (first.count > 0) {
                    pq.offer(first);
                }
            }
        }

        return sb.toString();
    }
}