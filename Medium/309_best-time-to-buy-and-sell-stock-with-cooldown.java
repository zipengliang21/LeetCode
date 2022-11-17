class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        // dp[i][j]: 第i天在状态j下的最大收益
        int[][] dp = new int[3][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            dp[i % 3][0] = Math.max(dp[(i - 1) % 3][0], dp[(i - 1) % 3][1] + prices[i]);
            dp[i % 3][1] = Math.max(dp[(i - 1) % 3][1], ((i - 2) < 0 ? 0 : dp[(i - 2) % 3][0]) - prices[i]);
        }

        return dp[(n - 1) % 3][0];
    }
}