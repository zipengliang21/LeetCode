class Solution {
    public int numTrees(int n) {
        Integer[] memo = new Integer[n + 1];
        return dfs(n, memo);
    }

    private int dfs(int n, Integer[] memo) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if (memo[n] != null) {
            return memo[n];
        }

        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += dfs(i - 1, memo) * dfs(n - i, memo);
        }

        return memo[n] = sum;
    }
}