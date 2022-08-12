package Medium;

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return false;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        int start = 0;
        int end = m * n - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            int x = mid / n;
            int y = mid % n;

            if (target == matrix[x][y]) {
                end = mid;
            } else if (matrix[x][y] < target) {
                start = mid;
            } else {
                // matrix[x][y] > target
                end = mid;
            }
        }

        if (matrix[start / n][start % n] == target || matrix[end / n][end % n] == target) {
            return true; // (start / n, start % n) or (end / n, end % n)
        }

        return false;
    }
}