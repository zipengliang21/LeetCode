class Solution {
    public int deleteAndEarn(int[] nums) {
        // 找nums中的最大值确定values数组的长度
        int max = 0;

        for (int num : nums) {
            max = Math.max(max, num);
        }

        // values数组
        int[] values = new int[max + 1];

        // 计算values数组： num作为index，点数价值作为value 点数价值 = num * num在nums中的出现次数
        for (int num : nums) {
            values[num] += num;
        }

        // 打家劫舍dp dp[i]:前i个获取的最大价值
        // function: dp[i] = Math.max(dp[i - 1], dp[i - 2] + values[i]);
        // condition: dp[0] = values[0], dp[1] = values[1]
        int[] dp = new int[2];
        dp[0] = 0;
        dp[1] = values[1];
        for (int i = 2; i < values.length; i++) {
            dp[i % 2] = Math.max(dp[(i - 1) % 2], dp[(i - 2) % 2] + values[i]);
        }

        return dp[(values.length - 1) % 2];
    }
}