class Solution {

    static final int MOD = 1_000_000_007;

    int[][] dir = {
        {0, -1},
        {-1, 0},
        {-1, -1}
    };

    public int[] pathsWithMaxScore(List<String> board) {

        int n = board.size();

        int[][] maxScore = new int[n][n];
        int[][] ways = new int[n][n];

        for (int[] row : maxScore)
            Arrays.fill(row, -1);

        maxScore[n - 1][n - 1] = 0;
        ways[n - 1][n - 1] = 1;

        for (int i = n - 1; i >= 0; i--) {

            for (int j = n - 1; j >= 0; j--) {

                if (board.get(i).charAt(j) == 'X')
                    continue;

                if (maxScore[i][j] == -1)
                    continue;

                for (int[] d : dir) {

                    int ni = i + d[0];
                    int nj = j + d[1];

                    if (ni < 0 || nj < 0)
                        continue;

                    char ch = board.get(ni).charAt(nj);

                    if (ch == 'X')
                        continue;

                    int val = (ch == 'S' || ch == 'E') ? 0 : ch - '0';

                    int newScore = maxScore[i][j] + val;

                    if (newScore > maxScore[ni][nj]) {

                        maxScore[ni][nj] = newScore;
                        ways[ni][nj] = ways[i][j];

                    } else if (newScore == maxScore[ni][nj]) {

                        ways[ni][nj] =
                            (ways[ni][nj] + ways[i][j]) % MOD;
                    }
                }
            }
        }

        if (maxScore[0][0] == -1)
            return new int[]{0, 0};

        return new int[]{maxScore[0][0], ways[0][0]};
    }
}