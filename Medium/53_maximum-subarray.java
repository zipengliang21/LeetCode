class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // state: dp[i]代表以nums[i]结尾的连续子数组最大和
        // int[] dp = new int[nums.length];

        // space optimization
        // condition: dp[0] = num[0];
        int dp = nums[0];
        int result = Integer.MIN_VALUE;
        result = Math.max(result, dp);
        // function: 制表法 =>
        // 1. if dp[i - 1] < 0 => nums[i]
        // 2. dp[i - 1] + nums[i]
        for (int i = 1; i < nums.length; i++) {
            if (dp > 0) {
                dp += nums[i];
            } else {
                dp = nums[i];
            }
            result = Math.max(result, dp);
        }

        return result;
    }
}