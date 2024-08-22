/*Alice and Bob continue their games with piles of stones.  There are a number of piles arranged in a row, and each pile has a positive integer number of stones piles[i]. 
The objective of the game is to end with the most stones. 
Alice and Bob take turns, with Alice starting first.  Initially, M = 1.
On each player's turn, that player can take all the stones in the first X remaining piles, where 1 <= X <= 2M.  Then, we set M = max(M, X).
The game continues until all the stones have been taken.
Assuming Alice and Bob play optimally, return the maximum number of stones Alice can get.*/

class Solution {
    public int stoneGameII(int[] piles) {
     int n = piles.length;
        int[] suffixSum = new int[n];
        
        // Compute suffix sum array
        suffixSum[n - 1] = piles[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixSum[i] = piles[i] + suffixSum[i + 1];
        }
        
        // DP array
        int[][] dp = new int[n][n + 1]; // dp[i][m]
        
        // Base case
        for (int i = 0; i < n; i++) {
            for (int m = 1; m <= n; m++) {
                if (i + 2 * m >= n) {
                    dp[i][m] = suffixSum[i]; // take all remaining stones
                } else {
                    for (int x = 1; x <= 2 * m; x++) {
                        dp[i][m] = Math.max(dp[i][m], suffixSum[i] - dp[i + x][Math.max(m,x)]);
                    }
                }
            }
        }
        
        return dp[0][1];
    }
}
