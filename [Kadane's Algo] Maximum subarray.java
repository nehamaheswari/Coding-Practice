class Solution {
    public int maxSubArray(int[] nums) {
        // Initialize maxSum with the first element
        int maxSum = nums[0];
        // Initialize currentSum with the first element
        int currentSum = nums[0];
        
        // Start iterating from the second element
        for (int i = 1; i < nums.length; i++) {
            // Update currentSum to be the maximum of the current element itself
            // or the current element added to the existing subarray sum
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            
            // Update maxSum if the new currentSum is greater than the previous maxSum
            maxSum = Math.max(maxSum, currentSum);
        }
        
        return maxSum;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int result = solution.maxSubArray(nums);
        System.out.println(result);  // Expected Output: 6, for subarray [4, -1, 2, 1]
    }
}
