//Reverse bits of a given 32 bits unsigned integer.

public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
    int result = 0;

        // Iterate over all 32 bits of the integer
        for (int i = 0; i < 32; i++) {
            // Shift result to the left by 1 to make space for the new bit
            result <<= 1;

          // Add the least significant bit (rightmost bit) of n to result
          //(n & 1) extracts the least significant bit (the rightmost bit) of n.
          //The & operator performs a bitwise AND operation between n and 1, which gives us the rightmost bit.
          //result |= (n & 1); then adds this bit to the result using the | (bitwise OR) operator. 
          //If the rightmost bit of n is 1, it sets the last bit of result to 1; otherwise, it remains 0.
            result |= (n & 1); 

            // Shift n to the right by 1 to process the next bit
            n >>= 1;
        }

        return result;
    }
}
