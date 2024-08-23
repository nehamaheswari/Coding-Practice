/*There is a strange printer with the following two special properties:

The printer can only print a sequence of the same character each time.
At each turn, the printer can print new characters starting from and ending at any place and will cover the original existing characters.
Given a string s, return the minimum number of turns the printer needed to print it.*/

class Solution {
    public int strangePrinter(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        int[][] dp = new int[n][n];
        for(int[] in: dp){
            Arrays.fill(in, -1);
        }

        return helper(0, n-1, arr, dp);
    }

    public int helper(int i, int j, char[] arr, int[][] dp){
        if(i > j) return 0;

        if(dp[i][j] != -1) return dp[i][j];
        char firstLetter = arr[i];
        int answer = helper(i+1, j, arr, dp) + 1;
        for(int k=i+1; k<=j; k++){
            if(firstLetter == arr[k]){
                int better = helper(i, k-1, arr, dp) + helper(k+1, j, arr, dp);
                answer = Math.min(better, answer);
            }
        }

        return dp[i][j] = answer;
    }
}
