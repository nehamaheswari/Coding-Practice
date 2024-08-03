//Given an integer array nums, find a subarray that has the largest product, and return the product.

class Solution {
    public int maxProduct(int[] nums) {
        // Handle edge case for empty array
        if (nums.length == 0) return 0;
        
        // Initialize variables
        int maxProduct = nums[0];
        int currentMax = nums[0];
        int currentMin = nums[0];
        
        // Iterate through the array starting from the second element
        for (int i = 1; i < nums.length; i++) {
            // If the current element is negative, swap currentMax and currentMin
            if (nums[i] < 0) {
                int temp = currentMax;
                currentMax = currentMin;
                currentMin = temp;
            }
            
            // Update currentMax and currentMin
            currentMax = Math.max(nums[i], currentMax * nums[i]);
            currentMin = Math.min(nums[i], currentMin * nums[i]);
            
            // Update maxProduct
            maxProduct = Math.max(maxProduct, currentMax);
        }
        
        return maxProduct;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2, 3, -2, 4};
        int result = solution.maxProduct(nums);
        System.out.println(result);  // Expected Output: 6 (from subarray [2, 3])
    }
}
