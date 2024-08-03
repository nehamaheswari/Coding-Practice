//Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

import java.util.HashSet;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();
       for (int num : nums) {
            if (!seen.add(num)) {
                return true; 
              //if (!seen.add(num)):This condition checks if num was not added to the set (i.e., num is already present in the set).
              //If num was not added (indicating a duplicate), the condition evaluates to true, and the method returns true.
            }
        }   
        return false;  // No duplicates found
    }
}
