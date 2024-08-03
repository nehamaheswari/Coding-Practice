import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            //The complement is the number that, when added to the current element nums[i], equals the target.
          
            if (map.containsKey(complement)) {
              //map.containsKey(complement): This checks if the complement is already in the hash map. 
              //If it is, it means there exists a previous element in the array that, when added to the current element, equals the target
                return new int[] { map.get(complement), i };
              //map.get(complement) retrieves the index of the complement from the hash map.
            }
            
            map.put(nums[i], i);
        }
        
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        
        int[] result = solution.twoSum(nums, target);
        System.out.println("Indices: " + result[0] + ", " + result[1]);  // Output: Indices: 0, 1
    }
}
