class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount < 0 || coins == null || coins.length == 0) {
            return -1;
        }

        int n = coins.length;
        int[] dp = new int[amount + 1];

        for (int j = 1; j <= amount; j++) {
            dp[j] = 20000;
            for (int i = 0; i < n; i++) {
                if (j >= coins[i] && dp[j - coins[i]] != 20000) {
                    // 加选第i种硬币
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }

        return dp[amount] == 20000 ? -1 : dp[amount];
    }
}