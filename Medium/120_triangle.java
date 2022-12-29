class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int m = triangle.get(n - 1).size();

        int[][] dp = new int[2][n];
        dp[0][0] = triangle.get(0).get(0);

        for (int i = 1; i < n; i++) {
            dp[i % 2][0] = dp[(i - 1) % 2][0] + triangle.get(i).get(0);
            for (int j = 1; j < triangle.get(i).size(); j++) {
                if (j == triangle.get(i).size() - 1) {
                    dp[i % 2][j] = dp[(i - 1) % 2][j - 1] + triangle.get(i).get(j);
                } else {
                    dp[i % 2][j] = Math.min(dp[(i - 1) % 2][j - 1], dp[(i - 1) % 2][j]) + triangle.get(i).get(j);
                }
            }
        }

        int result = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            result = Math.min(result, dp[(n - 1) % 2][j]);
        }

        return result;
    }
}