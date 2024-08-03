//TC: O(logn)
//SC: O(1)

class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            // Check if mid is the target
            if (nums[mid] == target) {
                return mid;
            }
            
            // Determine which half is sorted
            if (nums[left] <= nums[mid]) {
                // Left half is sorted
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;  // Search in the left half
                } else {
                    left = mid + 1;   // Search in the right half
                }
            } else {
                // Right half is sorted
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;   // Search in the right half
                } else {
                    right = mid - 1;  // Search in the left half
                }
            }
        }
        
        // Target not found
        return -1;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        int result = solution.search(nums, target);
        System.out.println(result);  // Expected Output: 4
        
        target = 3;
        result = solution.search(nums, target);
        System.out.println(result);  // Expected Output: -1
    }
}
