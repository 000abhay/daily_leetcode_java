import java.util.*;

class Solution {
    public int maximumInvitations(int[] favorite) {

        int n = favorite.length;

        int[] indegree = new int[n];

        for (int i = 0; i < n; i++) {
            indegree[favorite[i]]++;
        }

        int[] longest = new int[n];
        Arrays.fill(longest, 1);

        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {

            int node = queue.poll();
            int next = favorite[node];

            longest[next] = Math.max(
                longest[next],
                longest[node] + 1
            );

            indegree[next]--;

            if (indegree[next] == 0) {
                queue.offer(next);
            }
        }

        int maxCycle = 0;
        int twoCycleSum = 0;

        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {

            if (indegree[i] == 0 || visited[i]) {
                continue;
            }

            int j = favorite[i];

            if (favorite[j] == i) {

                twoCycleSum += longest[i] + longest[j];

                visited[i] = true;
                visited[j] = true;

            } else {

                int current = i;
                int cycleLength = 0;

                while (!visited[current]) {

                    visited[current] = true;
                    cycleLength++;
                    current = favorite[current];
                }

                maxCycle = Math.max(maxCycle, cycleLength);
            }
        }

        return Math.max(maxCycle, twoCycleSum);
    }
}