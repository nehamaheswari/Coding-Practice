/*Given two integers a and b, return the sum of the two integers without using the operators + and -.*/

class Solution {
    public int getSum(int a, int b) {
     while (b != 0) {
            // Calculate carry
            int carry = a & b;

            // Sum of bits where at least one of the bits is not set
            a = a ^ b; //XOR outputs 1 only when the bits are different, effectively summing the bits where there's no carry.

            // Carry is shifted by one so that adding it to `a` gives the required sum
            b = carry << 1; //This shift is necessary because, in binary addition, carries move to the next higher bit position.
        }

        return a;
    }
}
