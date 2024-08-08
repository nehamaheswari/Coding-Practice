class Solution {
    public void setZeroes(int[][] matrix) {
        int rowSize = matrix.length;
        int colSize = matrix[0].length; 
        
        boolean[] rowsToZero = new boolean[rowSize];
        boolean[] colsToZero = new boolean[colSize];

      //First Pass: Identify Rows and Columns to Zero:
        for(int r = 0 ; r < rowSize ; r++) {
            for(int c = 0 ; c < colSize ; c++) {
                if(matrix[r][c] == 0) {
                    rowsToZero[r] = true;
                    colsToZero[c] = true;
                }

            }
        }

      //Second Pass: Zero Out Rows and Columns:
        for (int r = 0; r < rowSize; r++) {
            for (int c = 0; c < colSize; c++) {
                if (rowsToZero[r] || colsToZero[c]) {
                    matrix[r][c] = 0;
                }
            }
        }
        
    }
}
