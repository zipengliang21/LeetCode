public class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
            return false;
        }

        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0) && !visited[i][j]) {
                    boolean hasWord = dfs(board, word, visited, i, j, 0);
                    if (hasWord) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, boolean[][] visited, int x, int y, int index) {
        // pruning
        if (board[x][y] != word.charAt(index)) {
            return false;
        }

        // mark current node
        visited[x][y] = true;

        // get the result
        if (index == word.length() - 1) {
            return true;
        }

        boolean hasWord = false;
        int[] dx = { 1, 0, -1, 0 };
        int[] dy = { 0, 1, 0, -1 };
        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if (checkRange(board, newX, newY) && !visited[newX][newY]) {
                hasWord = hasWord || dfs(board, word, visited, newX, newY, index + 1);
            }
        }

        visited[x][y] = false;
        return hasWord;
    }

    private boolean checkRange(char[][] board, int x, int y) {
        return x >= 0 && x < board.length && y >= 0 && y < board[0].length;
    }
}79_ word-search{

}
