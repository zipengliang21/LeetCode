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
    
    public void solve(char[][] board) {
        // Notice that an 'O' should not be flipped if - It is on the border
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
            return;
        }

        int m = board.length;
        int n = board[0].length;

        boolean[][] visited = new boolean[m][n];
        // staring from the 'O' in the border, calculate the connected component
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isBorder(m, n, i, j) && board[i][j] == 'O' && !visited[i][j]) {
                    bfs(board, visited, new Point(i, j));
                }
            }
        }

        // travsal the board, and change remaining 'O' to 'X', B to 'O'
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'B') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void bfs(char[][] board, boolean[][] visited, Point point) {
        Queue<Point> queue = new LinkedList<>();
        visited[point.x][point.y] = true;
        board[point.x][point.y] = 'B';
        
        queue.offer(point);
        
        while (!queue.isEmpty()) {
            Point curPoint = queue.poll();
            
            for (int i = 0; i < 4; i++) {
                Point newPoint = new Point(curPoint.x + dx[i], curPoint.y + dy[i]);
                if (checkRange(board, newPoint) && !visited[newPoint.x][newPoint.y] && board[newPoint.x][newPoint.y] == 'O') {
                    visited[newPoint.x][newPoint.y] = true;  
                    queue.offer(newPoint);
                    board[newPoint.x][newPoint.y] = 'B';
                }
            }
        }
    }

    private boolean checkRange(char[][] board, Point point) {
        return point.x >= 0 && point.x < board.length && point.y >= 0 && point.y < board[0].length;
    }

    private boolean isBorder(int m, int n, int x, int y) {
        return x == 0 || x == m - 1 || y == 0 || y == n - 1;
    }
}

// dfs
class Solution {
    public void solve(char[][] board) {
        // Notice that an 'O' should not be flipped if - It is on the border
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
            return;
        }

        int m = board.length;
        int n = board[0].length;

        boolean[][] visited = new boolean[m][n];
        // staring from the 'O' in the border, calculate the connected component
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isBorder(m, n, i, j) && board[i][j] == 'O' && !visited[i][j]) {
                    dfs(board, visited, i, j);
                }
            }
        }

        // travsal the board, and change remaining 'O' to 'X', B to 'O'
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'B') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, boolean[][] visited, int x, int y) {
        if (board[x][y] == 'X') {
            return;
        }

        // mark
        visited[x][y] = true;
        board[x][y] = 'B';

        // move
        int[] dx = { 1, 0, -1, 0 };
        int[] dy = { 0, 1, 0, -1 };
        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if (checkRange(board, newX, newY) && !visited[newX][newY]) {
                dfs(board, visited, newX, newY);
            }
        }
    }

    private boolean checkRange(char[][] board, int x, int y) {
        return x >= 0 && x < board.length && y >= 0 && y < board[0].length;
    }

    private boolean isBorder(int m, int n, int x, int y) {
        return x == 0 || x == m - 1 || y == 0 || y == n - 1;
    }
}