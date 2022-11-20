class Solution {
    public int rob(int[] nums) {
        // 分成2个House Robber I问题：dp[i]代表前i个房子打劫获取的最大价值。
        int result = 0;
        int n = nums.length;

        // dp1: 打劫第1个房子，不能打劫最后一个房子, dp[0] = 0, dp[1] = nums[0]; 跳过最后一个房子： i == n
        int[] dp = new int[2];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= n; i++) {
            if (i == n) {
                dp[i % 2] = dp[(i - 1) % 2];
                continue;
            }
            dp[i % 2] = Math.max(dp[(i - 1) % 2], dp[(i - 2) % 2] + nums[i - 1]);
        }

        result = dp[n % 2];

        // dp2: 打劫第2个房子，可打劫最后一个房子, dp[0] = 0, dp[1] = 0;
        dp[0] = 0;
        dp[1] = 0;

        for (int i = 2; i <= n; i++) {
            dp[i % 2] = Math.max(dp[(i - 1) % 2], dp[(i - 2) % 2] + nums[i - 1]);
        }

        return Math.max(result, dp[n % 2]);
    }
}