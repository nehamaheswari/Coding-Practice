/*Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
Time Complexity: O(m * n) where m is the number of rows and n is the number of columns, because we traverse the matrix a few times.
Space Complexity: O(1) additional space (excluding the input matrix), because we use the first row and column as storage for markers.*/

class Solution {
    public void setZeroes(int[][] matrix) {
      if (matrix == null || matrix.length == 0) return;

        int m = matrix.length;    // Number of rows
        int n = matrix[0].length; // Number of columns
      //Instead of using additional memory (e.g., another matrix or arrays) to keep track of which rows and columns should be zeroed, 
      //we can use the first row and the first column of the matrix itself to store this information.
        boolean firstRowZero = false;
        boolean firstColZero = false;

        // Step 1: Determine if the first row or first column should be zeroed
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                firstColZero = true;
                break;//This means that the entire first column will need to be zeroed later.
            }
        }

        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                firstRowZero = true;
                break;//This means that the entire first row will need to be zeroed later.
            }
        }

        // Step 2: Use the first row and column as markers
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0; // Mark the row
                    matrix[0][j] = 0; // Mark the column
                }
            }
        }

        // Step 3: Zero out cells based on markers in the first row and column
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                  //matrix[i][0] (row marker) and matrix[0][j] (column marker)
                    matrix[i][j] = 0;
                }
            }
        }

        // Step 4: Zero out the first row if needed
        if (firstRowZero) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }

        // Step 5: Zero out the first column if needed
        if (firstColZero) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }

}
