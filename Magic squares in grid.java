/*A 3 x 3 magic square is a 3 x 3 grid filled with distinct numbers from 1 to 9 such that each row, column, and both diagonals all have the same sum.
Given a row x col grid of integers, how many 3 x 3 contiguous magic square subgrids are there?
Note: while a magic square can only contain numbers from 1 to 9, grid may contain numbers up to 15.*/

class Solution {
    public int numMagicSquaresInside(int[][] grid) {
       int count = 0;
        
        for (int i = 0; i < grid.length - 2; i++) {
            for (int j = 0; j < grid[0].length - 2; j++) {
                if (isMagicSquare(grid, i, j)) {
                    count++;
                }
            }
        }
        
        return count;
    }

    private static boolean isMagicSquare(int[][] grid, int row, int col) {
        int[] nums = new int[10]; // Array to track numbers from 1 to 9
        
        // Check if all numbers from 1 to 9 are present
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                int num = grid[i][j];
                if (num < 1 || num > 9 || nums[num] == 1) {
                    return false;
                }
                nums[num] = 1;
            }
        }

        // Check sums of rows, columns, and diagonals
        int sum1 = grid[row][col] + grid[row][col + 1] + grid[row][col + 2];
        int sum2 = grid[row + 1][col] + grid[row + 1][col + 1] + grid[row + 1][col + 2];
        int sum3 = grid[row + 2][col] + grid[row + 2][col + 1] + grid[row + 2][col + 2];
        
        int colSum1 = grid[row][col] + grid[row + 1][col] + grid[row + 2][col];
        int colSum2 = grid[row][col + 1] + grid[row + 1][col + 1] + grid[row + 2][col + 1];
        int colSum3 = grid[row][col + 2] + grid[row + 1][col + 2] + grid[row + 2][col + 2];
        
        int diagonalSum1 = grid[row][col] + grid[row + 1][col + 1] + grid[row + 2][col + 2];
        int diagonalSum2 = grid[row][col + 2] + grid[row + 1][col + 1] + grid[row + 2][col];

        return sum1 == 15 && sum2 == 15 && sum3 == 15 && colSum1 == 15 && colSum2 == 15 &&
               colSum3 == 15 && diagonalSum1 == 15 && diagonalSum2 == 15;
    
    }
}
