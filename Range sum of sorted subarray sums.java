/*You are given the array nums consisting of n positive integers.
You computed the sum of all non-empty continuous subarrays from the array and then sorted them in non-decreasing order, creating a new array of n * (n + 1) / 2 numbers.
Return the sum of the numbers from index left to index right (indexed from 1), inclusive, in the new array. 
Since the answer can be a huge number return it modulo 109 + 7.*/


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        List<Integer> subarraySums = new ArrayList<>();
        int mod = 1_000_000_007;

        // Step 1: Generate all subarray sums
        for (int i = 0; i < n; i++) {
            int currentSum = 0;
            for (int j = i; j < n; j++) {
                currentSum += nums[j];
                subarraySums.add(currentSum);
            }
        }

        // Step 2: Sort the subarray sums
        Collections.sort(subarraySums);

        // Step 3: Compute the sum of the elements between left and right (1-indexed)
        long result = 0;`1
        for (int i = left - 1; i < right; i++) {
            result = (result + subarraySums.get(i)) % mod;
        }

        // Step 4: Return the result modulo 10^9 + 7
        return (int) result;
    }
}
