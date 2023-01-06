class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int result = 0;

        // State: d[i][j] means whether substring starting from i with length of j + 1
        // is palindrome
        boolean[][] dp = new boolean[n][n];

        // condition: dp[i][0] = true
        // dp[i][1] = s.charAt(i) == s.charAt(i + 1)

        // Function: for len > 2
        // dp[i][j] = dp[i + 1][j - 2] && s.charAt(i) == s.charAt(i + j)
        for (int j = 0; j < n; j++) {
            for (int i = 0; i + j < n; i++) {
                dp[i][j] = s.charAt(i) == s.charAt(i + j) && (j < 2 || dp[i + 1][j - 2]);

                if (dp[i][j]) {
                    result++;
                }
            }
        }

        return result;
    }
}