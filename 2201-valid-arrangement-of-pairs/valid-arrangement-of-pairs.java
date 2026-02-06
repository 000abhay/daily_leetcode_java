import java.util.*;

class Solution {

    Map<Integer, Deque<Integer>> adj = new HashMap<>();
    List<int[]> path = new ArrayList<>();

    public int[][] validArrangement(int[][] pairs) {

        Map<Integer, Integer> indeg = new HashMap<>();
        Map<Integer, Integer> outdeg = new HashMap<>();

        // 1. Build graph + indegree/outdegree
        for (int[] p : pairs) {
            int u = p[0], v = p[1];

            adj.computeIfAbsent(u, k -> new ArrayDeque<>()).add(v);

            outdeg.put(u, outdeg.getOrDefault(u, 0) + 1);
            indeg.put(v, indeg.getOrDefault(v, 0) + 1);
        }

        // 2. Find start node
        int start = pairs[0][0];
        for (int node : outdeg.keySet()) {
            if (outdeg.get(node) == indeg.getOrDefault(node, 0) + 1) {
                start = node;
                break;
            }
        }

        // 3. DFS (Hierholzer)
        dfs(start);

        // 4. Build result (reverse order)
        int n = pairs.length;
        int[][] res = new int[n][2];
        for (int i = 0; i < n; i++) {
            res[i] = path.get(n - 1 - i);
        }

        return res;
    }

    private void dfs(int u) {
        Deque<Integer> q = adj.get(u);

        while (q != null && !q.isEmpty()) {
            int v = q.poll();
            dfs(v);
            path.add(new int[]{u, v});
        }
    }
}
