class Solution {
    public int combinationSum4(int[] nums, int target) {
        if (nums == null || nums.length == 0 || target < 0) {
            return 0;
        }

        int[] dp = new int[target + 1];
        dp[0] = 1;

        // 顺序不同的序列被视作不同的组合 => 先遍历金额
        for (int j = 1; j <= target; j++) {
            for (int num : nums) {
                if (j >= num) {
                    dp[j] += dp[j - num];
                }
            }
        }

        return dp[target];
    }
}