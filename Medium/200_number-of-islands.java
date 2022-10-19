// bfs
class Solution {
    class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        
        int numIslands = 0;
        
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Point start = new Point(i, j);
                if (grid[i][j] == '1' && !visited[i][j]) {
                    bfs(grid, visited, start);
                    numIslands++;
                }
            }
        }
        
        return numIslands;
    }
    
    private void bfs(char[][] grid, boolean[][] visited, Point start) {
        Queue<Point> queue = new LinkedList<>();
        visited[start.x][start.y] = true;
        
        queue.offer(start);
        
        while (!queue.isEmpty()) {
            Point curPoint = queue.poll();
            
            for (int i = 0; i < 4; i++) {
                Point newPoint = new Point(curPoint.x + dx[i], curPoint.y + dy[i]);
                if (checkRange(grid, newPoint) && !visited[newPoint.x][newPoint.y] && grid[newPoint.x][newPoint.y] == '1') {
                    visited[newPoint.x][newPoint.y] = true;  
                    queue.offer(newPoint);
                }
            }
        }
    }
    
    private boolean checkRange(char[][] grid, Point point) {
        return point.x >= 0 && point.x < grid.length && point.y >= 0 && point.y < grid[0].length;
    }
}


// dfs
class Solution {
    public int numIslands(char[][] grid) {
        int ans = 0;
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return ans;
        }

        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(grid, visited, i, j);
                    ans++;
                }
            }
        }

        return ans;
    }

    private void dfs(char[][] grid, boolean[][] visited, int x, int y) {
        // mark
        visited[x][y] = true;

        if (grid[x][y] == '0') {
            return;
        }

        // move
        int[] dx = { 1, 0, -1, 0 };
        int[] dy = { 0, 1, 0, -1 };
        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if (checkRange(grid, newX, newY) && !visited[newX][newY]) {
                dfs(grid, visited, newX, newY);
            }
        }
    }

    private boolean checkRange(char[][] grid, int x, int y) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length;
    }
}