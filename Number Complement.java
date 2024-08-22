/*The complement of an integer is the integer you get when you flip all the 0's to 1's and all the 1's to 0's in its binary representation.

For example, The integer 5 is "101" in binary and its complement is "010" which is the integer 2.
Given an integer num, return its complement.*/

class Solution {
    public int findComplement(int num) {
      //Integer.toBinaryString(num) converts the integer num to its binary string representation.  
      //.length() gives the number of bits in this binary string.
    int bitLength = Integer.toBinaryString(num).length();
        
        // Create a mask with all bits set to 1 that is the same length as the number
        int mask = (1 << bitLength) - 1;
        
        // XOR the number with the mask to flip all bits
        return num ^ mask;
    }
}
