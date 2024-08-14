/*The distance of a pair of integers a and b is defined as the absolute difference between a and b.
Given an integer array nums and an integer k, return the kth smallest distance among all the pairs nums[i] and nums[j] where 0 <= i < j < nums.length*/

class Solution {
    public int smallestDistancePair(int[] nums, int k) {
     Arrays.sort(nums); // Step 1: Sort the array

        int left = 0; // minimum possible distance
        int right = nums[nums.length - 1] - nums[0]; // maximum possible distance

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (countPairs(nums, mid) >= k) {
                right = mid; // search the left half
            } else {
                left = mid + 1; // search the right half
            }
        }
        return left; // this will be the kth smallest distance
    }

    private int countPairs(int[] nums, int mid) {
        int count = 0;
        int j = 0;

        for (int i = 0; i < nums.length; i++) {
            while (j < nums.length && nums[j] - nums[i] <= mid) {
                j++;
            }
            count += j - i - 1; // count pairs with nums[i] as the first element
        }

        return count;
    }
}
