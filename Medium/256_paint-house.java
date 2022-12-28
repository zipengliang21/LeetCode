class Solution {
    public int minCost(int[][] costs) {
        int n = costs.length;
        // state: dp[i][k]: 用颜色k粉刷第i个房子的最小成本
        // function: dp[i][k] = min(dp[i][k], dp[i - 1][j] (j != k) + cost[i][k]);
        // condition: dp[0][0] = costs[0][0] dp[0][0] = costs[0][1] dp[0][2] =
        // costs[0][2]
        // solution: min(dp[n - 1][k]) 其中k = 0, 1, 2

        int[][] dp = new int[2][3];
        for (int i = 0; i < 3; i++) {
            dp[0][i] = costs[0][i];
        }

        for (int i = 1; i < n; i++) {
            for (int k = 0; k < 3; k++) {
                dp[i % 2][k] = Integer.MAX_VALUE;
                for (int j = 0; j < 3; j++) {
                    if (j != k) {
                        dp[i % 2][k] = Math.min(dp[i % 2][k], dp[(i - 1) % 2][j] + costs[i][k]);
                    }
                }
            }
        }

        return Math.min(dp[(n - 1) % 2][0], Math.min(dp[(n - 1) % 2][1], dp[(n - 1) % 2][2]));
    }
}