class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        // dp[i]: 在第i个房屋时获得最高金额
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] dp = new int[2];
        dp[0] = 0;
        dp[1] = nums[0];
        int n = nums.length;
        for (int i = 2; i <= n; i++) {
            dp[i % 2] = Math.max(dp[(i - 1) % 2], dp[(i - 2) % 2] + nums[i - 1]);
        }

        return dp[n % 2];
    }
}