/*You start at the cell (rStart, cStart) of an rows x cols grid facing east. 
The northwest corner is at the first row and column in the grid, and the southeast corner is at the last row and column.
You will walk in a clockwise spiral shape to visit every position in this grid. 
Whenever you move outside the grid's boundary, we continue our walk outside the grid (but may return to the grid boundary later.). 
Eventually, we reach all rows * cols spaces of the grid.
Return an array of coordinates representing the positions of the grid in the order you visited them*/

class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
       int[][] result = new int[rows * cols][2];
        int[][] directions = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} }; // Right, Down, Left, Up
        int x = rStart, y = cStart; // Starting position
        int dir = 0; // Start by moving right
        int steps = 1; // Initial step size
        int index = 0;
        
        result[index++] = new int[]{x, y}; // Add the starting position

        while (index < rows * cols) {
            for (int i = 0; i < 2; i++) { // Two passes for each step length
                for (int j = 0; j < steps; j++) {
                    x += directions[dir][0];
                    y += directions[dir][1];
                    
                    // Only add valid positions inside the grid
                    if (x >= 0 && x < rows && y >= 0 && y < cols) {
                        result[index++] = new int[]{x, y};
                    }
                }
                dir = (dir + 1) % 4; // Change direction clockwise
            }
            steps++; // Increase step size after two directions
        }
        
        return result;
    }

}
