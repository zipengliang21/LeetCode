class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return ans;
        }

        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    ans = Math.max(ans, dfs(grid, visited, i, j));
                }
            }
        }

        return ans;
    }

    private int dfs(int[][] grid, boolean[][] visited, int x, int y) {
        // mark
        visited[x][y] = true;

        if (grid[x][y] == 0) {
            return 0;
        }

        int ans = 1;
        // move
        int[] dx = { 1, 0, -1, 0 };
        int[] dy = { 0, 1, 0, -1 };
        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if (checkRange(grid, newX, newY) && !visited[newX][newY]) {
                ans += dfs(grid, visited, newX, newY);
            }
        }

        return ans;
    }

    private boolean checkRange(int[][] grid, int x, int y) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length;
    }
}