/*Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.*/

class Solution {
    public int missingNumber(int[] nums) {
     int n = nums.length;
        int expectedSum = n * (n + 1) / 2; // Calculate the expected sum
        int actualSum = 0;
        
        for (int num : nums) {
            actualSum += num; // Calculate the sum of elements in the array
        }
        
        return expectedSum - actualSum; // The difference is the missing number
    }
}
