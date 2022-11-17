class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[2];
        dp[0 % 2] = 0;
        dp[1 % 2] = 0;

        for (int i = 2; i <= cost.length; i++) {
            dp[i % 2] = Math.min(dp[(i - 2) % 2] + cost[i - 2], dp[(i - 1) % 2] + cost[i - 1]);
        }

        return dp[n % 2];
    }
}