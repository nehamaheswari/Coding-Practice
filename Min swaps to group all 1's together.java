/*A swap is defined as taking two distinct positions in an array and swapping the values in them.

A circular array is defined as an array where we consider the first element and the last element to be adjacent.

Given a binary circular array nums, return the minimum number of swaps required to group all 1's present in the array together at any location.*/


public class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int countOnes = 0;

        // Count total number of 1's
        for (int num : nums) {
            countOnes += num;
        }

        // Edge case: if there are no 1's or all are 1's, no swap is needed
        if (countOnes == 0 || countOnes == n) {
            return 0;
        }

        // Calculate number of 1's in the first window of size countOnes
        int maxOnesInWindow = 0, currentOnes = 0;
        for (int i = 0; i < countOnes; i++) {
            currentOnes += nums[i];
        }

        maxOnesInWindow = currentOnes;

        // Slide the window over the circular array
        for (int i = 1; i < n; i++) {
            // Update the window by removing the element that goes out and adding the new one
            currentOnes += nums[(i + countOnes - 1) % n] - nums[i - 1];
            /*New Element: (i + countOnes - 1) % n
              This calculates the index of the new element entering the window.
              i is the start of the new window, and countOnes - 1 is used to find the end of the window. 
              Using modulo % n handles the circular nature by wrapping around if needed.
              Old Element: nums[i - 1]
              This is the element that is leaving the window as it slides forward.*/
            maxOnesInWindow = Math.max(maxOnesInWindow, currentOnes);
        }

        // The minimum number of swaps required
        return countOnes - maxOnesInWindow;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {0, 1, 0, 1, 1, 0, 0};
        System.out.println(solution.minSwaps(nums));  // Output: 1
    }
}
