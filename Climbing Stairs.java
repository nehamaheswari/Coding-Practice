/*You are climbing a staircase. It takes n steps to reach the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?*/

public class Solution {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        
        // Initialize the base cases
        int first = 1;
        int second = 2;
        
        // Use a loop to build the solution from the bottom up
        for (int i = 3; i <= n; i++) {
            int third = first + second;  // f(i) = f(i-1) + f(i-2)
            first = second;  // Move the window
            second = third;
        }
        
        return second;
    }
}
