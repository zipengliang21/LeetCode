class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text1.length() == 0 || text2 == null || text2.length() == 0) {
            return 0;
        }

        int m = text1.length();
        int n = text2.length();

        int[][] dp = new int[2][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i % 2][j] = Math.max(dp[(i - 1) % 2][j], dp[i % 2][j - 1]);
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i % 2][j] = Math.max(dp[i % 2][j], dp[(i - 1) % 2][j - 1] + 1);
                }
            }
        }

        return dp[m % 2][n];
    }
}