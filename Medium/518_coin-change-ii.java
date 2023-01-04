class Solution {
    public int change(int amount, int[] coins) {
        if (amount < 0 || coins == null || coins.length == 0) {
            return 0;
        }

        int[] dp = new int[amount + 1];
        dp[0] = 1;

        // 先遍历硬币防止重复
        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                dp[j] += dp[j - coin];
            }
        }

        return dp[amount];
    }
}