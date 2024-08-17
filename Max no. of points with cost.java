/*You are given an m x n integer matrix points (0-indexed). Starting with 0 points, you want to maximize the number of points you can get from the matrix.
To gain points, you must pick one cell in each row. Picking the cell at coordinates (r, c) will add points[r][c] to your score.
However, you will lose points if you pick a cell too far from the cell that you picked in the previous row.
For every two adjacent rows r and r + 1 (where 0 <= r < m - 1), picking cells at coordinates (r, c1) and (r + 1, c2) will subtract abs(c1 - c2) from your score.
Return the maximum number of points you can achieve.*/

class Solution {
    public long maxPoints(int[][] points) {
     int cols = points[0].length;
        long[] currentRow = new long[cols], previousRow = new long[cols];

        for (int[] row : points) {
            // runningMax holds the maximum value generated in the previous iteration of each loop
            long runningMax = 0;

            // Left to right pass
            for (int col = 0; col < cols; ++col) {
                runningMax = Math.max(runningMax - 1, previousRow[col]);
                currentRow[col] = runningMax;
            }

            runningMax = 0;
            // Right to left pass
            for (int col = cols - 1; col >= 0; --col) {
                runningMax = Math.max(runningMax - 1, previousRow[col]);
                currentRow[col] = Math.max(currentRow[col], runningMax) +
                row[col];
            }

            // Update previousRow for next iteration
            previousRow = currentRow;
        }

        // Find maximum points in the last row
        long maxPoints = 0;
        for (int col = 0; col < cols; ++col) {
            maxPoints = Math.max(maxPoints, previousRow[col]);
        }

        return maxPoints;
    }
}
