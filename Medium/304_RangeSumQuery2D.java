class NumMatrix {

    private int[][] prefixSum;
    public NumMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0) {
            prefixSum = null;
        }

        if(matrix[0] == null || matrix[0].length == 0) {
            prefixSum = null;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        this.prefixSum = new int[m + 1][n+1]; // space complexity: O(m * n)

        // O(m * n)
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                prefixSum[i + 1][j + 1] = prefixSum[i][j + 1] + prefixSum[i + 1][j] 
                                          - prefixSum[i][j] + matrix[i][j];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        // O(1)
        return prefixSum[row2 + 1][col2 + 1] - prefixSum[row1][col2 + 1]
                - prefixSum[row2 + 1][col1] + prefixSum[row1][col1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */



 /**
        BF:
         int sum = 0;
        for(int i = row1; i <= row2; i++) {
            for(int j = col1; j <= col2; j++) {
                sum += matrix[i][j];
            }
        }
        return sum;
  */