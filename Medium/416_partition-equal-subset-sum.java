class Solution {
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length < 2) {
            return false;
        }

        int sum = 0;
        for (int num: nums) {
            sum += num;
        }

        if (sum % 2 != 0) {
            return false;
        }

        int target = sum / 2;

        boolean[][] dp = new boolean[nums.length][target + 1];

        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= target; j++) {
                // 背包容量不够
                if (j < nums[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] | dp[i - 1][j - nums[i]];
                }
            }
        }

        return dp[nums.length - 1][target];
    }
}