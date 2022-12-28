class Solution {
    public int minDistance(String word1, String word2) {
        if (word1 == null && word2 == null) {
            return 0;
        }

        int n = word1.length();
        int m = word2.length();

        // dp[i][j]: word1中[0, i]串变成word2中[0, j]串所使用的最少操作数
        int[][] dp = new int[2][m + 1];

        for (int j = 0; j <= m; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= n; i++) {
            dp[i % 2][0] = i;
            for (int j = 1; j <= m; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i % 2][j] = dp[(i - 1) % 2][j - 1];
                } else {
                    dp[i % 2][j] = Math.min(dp[(i - 1) % 2][j], Math.min(dp[i % 2][j - 1], dp[(i - 1) % 2][j - 1])) + 1;
                }
            }
        }

        return dp[n % 2][m];
    }
}