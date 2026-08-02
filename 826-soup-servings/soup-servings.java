class Solution {

    double[][] memo;
    int[][] moves = {
        {4, 0},
        {3, 1},
        {2, 2},
        {1, 3}
    };

    private double dfs(int a, int b) {

        if (a <= 0 && b <= 0) return 0.5;
        if (a <= 0) return 1.0;
        if (b <= 0) return 0.0;

        if (memo[a][b] != -1.0)
            return memo[a][b];

        double ans = 0.0;

        for (int[] move : moves) {
            ans += dfs(a - move[0], b - move[1]);
        }

        memo[a][b] = ans * 0.25;
        return memo[a][b];
    }

    public double soupServings(int n) {

        // Probability is effectively 1 for large n
        if (n >= 4800) return 1.0;

        int m = (n + 24) / 25;

        memo = new double[m + 1][m + 1];
        for (int i = 0; i <= m; i++) {
            Arrays.fill(memo[i], -1.0);
        }

        return dfs(m, m);
    }
}