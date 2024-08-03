//Given the sorted rotated array nums of unique elements, return the minimum element of this array.

//Using Binary Search for O(logn) TC
class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        
        // Handle the case where the array is not rotated
        //If nums[left] < nums[right], the array is not rotated, and the minimum element is nums[left]
        if (nums[left] < nums[right]) {
            return nums[left];
        }
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] > nums[right]) {
                // Minimum element is in the right part
                left = mid + 1;
            } else {
                // Minimum element is in the left part including mid
                right = mid;
            }
        }
        
        return nums[left];
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int result = solution.findMin(nums);
        System.out.println(result);  // Expected Output: 0
    }
}
