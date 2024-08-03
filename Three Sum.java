import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);  // Step 1: Sort the array
        
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;  // Skip duplicate elements
            }
            
            int left = i + 1;  // The start of the remaining array
            int right = nums.length - 1;  // The end of the remaining array
            
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    
                    // Move the left pointer to the next different number
                    //Duplicate Check: nums[left] == nums[left + 1]
                    //increment the left pointer (left++) to skip over all consecutive duplicate elements.
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    // Move the right pointer to the next different number
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    
                    // Move both pointers inward after adding a valid triplet
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;  // Increase the sum by moving the left pointer to the right
                } else {
                    right--;  // Decrease the sum by moving the right pointer to the left
                }
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = solution.threeSum(nums);
        
        for (List<Integer> triplet : result) {
            System.out.println(triplet);
        }
        // Expected Output:
        // [-1, -1, 2]
        // [-1, 0, 1]
    }
}
