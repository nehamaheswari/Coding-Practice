/*Write a function that takes the binary representation of a positive integer and returns the number of 
set bits it has (also known as the Hamming weight).*/

class Solution {
    public int hammingWeight(int n) {
      int count = 0;

        while (n != 0) {
            // Check the least significant bit (rightmost bit)
            count += n & 1;

            // Shift the bits of n to the right by 1 position
            n >>= 1;
        }

        return count;
    }
}
