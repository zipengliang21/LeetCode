class Solution {
    public int minCost(int[][] costs) {
        int n = costs.length;
        int K = costs[0].length;
        // state: dp[i][k]: 用颜色k粉刷第i个房子的最小成本
        // function: dp[i][k] = min(dp[i][k], dp[i - 1][j] (j != k) + cost[i][k]);
        // condition: dp[0][i] = costs[0][i] i -> [0,K)
        // solution: min(dp[n - 1][i]) 其中i -> [0,K)

        int[][] dp = new int[2][K];
        for (int i = 0; i < K; i++) {
            dp[0][i] = costs[0][i];
        }

        // 时间复杂度：O（n * K ^ 2）
        for (int i = 1; i < n; i++) { // n
            for (int k = 0; k < K; k++) {
                dp[i % 2][k] = Integer.MAX_VALUE;
                for (int j = 0; j < K; j++) { // K
                    if (j != k) { // K
                        dp[i % 2][k] = Math.min(dp[i % 2][k], dp[(i - 1) % 2][j] + costs[i][k]);
                    }
                }
            }
        }

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < K; i++) {
            result = Math.min(result, dp[(n - 1) % 2][i]);
        }

        return result;
    }
}

class Solution {
    public int minCost(int[][] costs) {
        int n = costs.length;
        int K = costs[0].length;
        // state: dp[i][k]: 用颜色k粉刷第i个房子的最小成本
        // function: dp[i][k] = min(dp[i][k], dp[i - 1][j] (j != k) + cost[i][k]);
        // condition: dp[0][i] = costs[0][i] i -> [0,K)
        // solution: min(dp[n - 1][i]) 其中i -> [0,K)

        int[][] dp = new int[2][K];
        for (int i = 0; i < K; i++) {
            dp[0][i] = costs[0][i];
        }

        int c = Integer.MAX_VALUE;
        int secondMinCost = Integer.MAX_VALUE;
        // 时间复杂度：O（n * K）
        for (int i = 1; i < n; i++) { // n
            minCost = Integer.MAX_VALUE;
            secondMinCost = Integer.MAX_VALUE;
            // 计算更新dp[ - 1][k] 最小成本和第2小成本
            for (int k = 0; k < K; k++) { // K
                if (dp[(i - 1) % 2][k] <= minCost) {
                    secondMinCost = minCost;
                    minCost = dp[(i - 1) % 2][k];
                } else if (dp[(i - 1) % 2][k] <= secondMinCost) {
                    secondMinCost = dp[(i - 1) % 2][k];
                }
            }

            for (int k = 0; k < K; k++) { // K
                // 当前第i个房子刷颜色k，与minCost刷的颜色一样
                if (dp[(i - 1) % 2][k] == minCost) {
                    dp[i % 2][k] = secondMinCost + costs[i][k];
                } else {
                    dp[i % 2][k] = minCost + costs[i][k];
                }
            }
        }

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < K; i++) {
            result = Math.min(result, dp[(n - 1) % 2][i]);
        }

        return result;
    }
}