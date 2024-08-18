/*An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.
Given an integer n, return the nth ugly number.*/

class Solution {
    public int nthUglyNumber(int n) {
     // Array to store ugly numbers
        int[] uglyNumbers = new int[n];
        uglyNumbers[0] = 1; // First ugly number is 1

        // Indexes for the next multiple of 2, 3, and 5
        int i2 = 0, i3 = 0, i5 = 0;

        // Next multiples of 2, 3, and 5
        int nextMultipleOf2 = 2;
        int nextMultipleOf3 = 3;
        int nextMultipleOf5 = 5;

        // Loop to populate the ugly number array
        for (int i = 1; i < n; i++) 
        {
            // Choose the smallest next multiple
            int nextUglyNumber = Math.min(nextMultipleOf2, Math.min(nextMultipleOf3, nextMultipleOf5));

            uglyNumbers[i] = nextUglyNumber;

            // Update the multiple indexes
            if (nextUglyNumber == nextMultipleOf2)
            {
                i2++;
                nextMultipleOf2 = uglyNumbers[i2] * 2;
            }
            if (nextUglyNumber == nextMultipleOf3) 
            {
                i3++;
                nextMultipleOf3 = uglyNumbers[i3] * 3;
            }
            if (nextUglyNumber == nextMultipleOf5)
            {
                i5++;
                nextMultipleOf5 = uglyNumbers[i5] * 5;
            }
        }

        // Return the nth ugly number
        return uglyNumbers[n - 1];
    }
}
