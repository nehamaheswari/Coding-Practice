//Given an m x n matrix, return all elements of the matrix in spiral order.
/*[1,2,3]                                   Top boundary moves down after traversing from left to right.
  [4,5,6]                                   Right boundary moves left after traversing from top to bottom.
  [7,8,9]                                   Bottom boundary moves up after traversing from right to left.
  1->2->3->6->9->8->7->4->5                 Left boundary moves right after traversing from bottom to top.*/

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        
        if (matrix == null || matrix.length == 0) {
            return result;
        }
        
        int m = matrix.length;    // Number of rows
        int n = matrix[0].length; // Number of columns
        
        int top = 0;
        int bottom = m - 1;
        int left = 0;
        int right = n - 1;
        
        while (top <= bottom && left <= right) {
            // Traverse from left to right along the top row
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++; // Move the top boundary down
            
            // Traverse from top to bottom along the right column
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--; // Move the right boundary left
            
            if (top <= bottom) { //to ensure that the current layer of the spiral hasn't collapsed vertically.
                // Traverse from right to left along the bottom row
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--; // Move the bottom boundary up
            }
            
            if (left <= right) { //to ensure that the current layer of the spiral hasn't collapsed horizontally.
                // Traverse from bottom to top along the left column
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++; // Move the left boundary right
            }
        }
        
        return result;
    }
}
