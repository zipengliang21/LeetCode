class Solution {
    public int uniquePaths(int m, int n) {
        // state: dp[i][j]代表从start到(i, j)共有多少条不同的路径
        int[][] dp = new int[2][n];

        // 只有往右走一种方案
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            dp[i % 2][0] = 1;
            for (int j = 1; j < n; j++) {
                dp[i % 2][j] = dp[(i - 1) % 2][j] + dp[i % 2][j - 1];
            }
        }

        return dp[(m - 1) % 2][n - 1];
    }
}