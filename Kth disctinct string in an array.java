/*A distinct string is a string that is present only once in an array.
Given an array of strings arr, and an integer k, return the kth distinct string present in arr.
If there are fewer than k distinct strings, return an empty string "".
Note that the strings are considered in the order in which they appear in the array.*/

//TC:O(n)
//SC:O(n)
class Solution {
    public static String kthDistinct(String[] arr, int k) {
        // Create a HashMap to store the frequency of each string
        HashMap<String, Integer> frequencyMap = new HashMap<>();
        
        // Count the frequency of each string in the array
        for (String s : arr) {
            frequencyMap.put(s, frequencyMap.getOrDefault(s, 0) + 1);
          //getOrDefault(s, 0) is a method of HashMap that tries to get the value associated with the key s
          //If s is not in the map, it returns the default value 0.
          //+ 1 increments this count by 1. This means we're counting one more occurrence of the string s.
        }
        
        // Iterate through the array to find the kth distinct string
        int count = 0;
        for (String s : arr) {
            if (frequencyMap.get(s) == 1) { // Check if the string is distinct
                count++;
                if (count == k) {
                    return s;
                }
            }
        }
        
        // If there are fewer than k distinct strings, return an empty string
        return "";
    }

    public static void main(String[] args) {
        String[] arr = {"a", "b", "a", "c", "b", "d"};
        int k = 2;
        
        String result = kthDistinct(arr, k);
        System.out.println(result);  // Output: "c"
    }
}
