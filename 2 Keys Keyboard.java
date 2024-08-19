/*There is only one character 'A' on the screen of a notepad. You can perform one of two operations on this notepad for each step:

Copy All: You can copy all the characters present on the screen (a partial copy is not allowed).
Paste: You can paste the characters which are copied last time.
Given an integer n, return the minimum number of operations to get the character 'A' exactly n times on the screen.*/

class Solution {
    public int minSteps(int n) {
        int ans = 0;

        // Iterate over possible factors starting from 2
        for (int i = 2; i * i <= n;) {
            if (n % i == 0) 
            {  // If 'i' is a factor of 'n'
                ans += i;       // Add 'i' to the answer (this is the number of operations)
                n = n / i;      // Divide 'n' by 'i' to reduce 'n'
            } 
            else
            {
                i++;            // Move to the next possible factor
            }
        }

        // If 'n' is greater than 1 after the loop, it is prime and should be added to the answer
        if (n != 1) 
            ans = ans + n;

        return ans; // Return the total number of operations
    }
}
