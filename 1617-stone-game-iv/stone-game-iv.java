class Solution {

    int[][] memo;

    void fun(List<Integer> store, int n) {
        for (int i = 1; i * i <= n; i++) {
            store.add(i * i);
        }
    }

    boolean top_down(List<Integer> store, int n, boolean flag) {

        int turn = flag ? 1 : 0;

        // Already calculated
        if (memo[n][turn] != -1) {
            return memo[n][turn] == 1;
        }

        // No stones left
        if (n == 0) {
            memo[n][turn] = flag ? 0 : 1;
            return flag ? false : true;
        }

        // Alice's turn
        if (flag) {

            for (int x : store) {

                if (x > n)
                    break;

                // Alice wants to find ONE move that makes her win
                if (top_down(store, n - x, false)) {
                    memo[n][turn] = 1;
                    return true;
                }
            }

            // Alice couldn't find a winning move
            memo[n][turn] = 0;
            return false;
        }

        // Bob's turn
        else {

            for (int x : store) {

                if (x > n)
                    break;

                // Bob wants to find ONE move that makes Alice lose
                if (!top_down(store, n - x, true)) {
                    memo[n][turn] = 0;
                    return false;
                }
            }

            // Bob couldn't make Alice lose
            memo[n][turn] = 1;
            return true;
        }
    }

    public boolean winnerSquareGame(int n) {

        memo = new int[n + 1][2];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(memo[i], -1);
        }

        List<Integer> store = new ArrayList<>();

        fun(store, n);

        return top_down(store, n, true);
    }
}