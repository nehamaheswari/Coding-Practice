/*Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.*/

class Solution {
    public int[] countBits(int n) {
      int[] ans = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            ans[i] = ans[i >> 1] + (i & 1);
          //i >> 1 : This operation shifts the bits of i to the right by one position, which is equivalent to dividing i by 2.
          //ans[i >> 1] : is the number of 1s in the binary representation of i // 2.
          //i & 1 : This means that (i & 1) adds 1 if i is odd, and 0 if i is even.
          //If i is odd, the last bit is 1, so i & 1 is 1.
          //If i is even, the last bit is 0, so i & 1 is 0.
        }
        return ans;
    }
}
