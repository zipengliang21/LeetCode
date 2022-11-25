class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // 制表法programming
        // dp[i]: 以nums[i]结尾的最长严格递增子序列的长度
        // 由于要最终要遍历dp数组取得最长严格递增子序列的长度，所以无法状态压缩，不能用滚动数组
        int[] dp = new int[nums.length];
        // 每个以nums[i]结尾的最长严格递增子序列的最小长度至少为1
        Arrays.fill(dp, 1);
        // function? 制表法programming => 得到递归函数表达式
        for (int i = 0; i < nums.length; i++) {
            // 找之前结尾比nums[i]小的递增子序列，然后找到其中最长的
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        // solution: 遍历dp数组取得最长严格递增子序列的长度
        int result = 0;
        for (int value : dp) {
            result = Math.max(result, value);
        }

        return result;
    }
}