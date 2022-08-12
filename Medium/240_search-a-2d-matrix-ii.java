package Medium;

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return false;
        }

        // upper right corner (0, n - 1). go down -> increase; go left -> decrease
        // lower left corner (m - 1, 0). go right -> increase; go up -> decrease
        int m = matrix.length;
        int n = matrix[0].length;

        int x = 0; // m - 1
        int y = n - 1; // 0

        while (x < m && y >= 0) { // x >= 0 && y < n
            if (matrix[x][y] == target) {
                return true;
            } else if (matrix[x][y] > target) {
                y--; // x--
            } else {
                // matrix[x][y] < target
                x++; // y++
            }
        }

        return false;
    }
}
