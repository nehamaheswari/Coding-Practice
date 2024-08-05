import java.util.*;

public class Solution {
    public static List<List<String>> groupAnagrams(String[] strs) {
        // HashMap to store the grouped anagrams
        Map<String, List<String>> anagramMap = new HashMap<>();
        
        // Iterate over each string in the array
        for (String str : strs) {
            // Convert the string to a character array and sort it
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            // Convert the sorted character array back to a string
            String sortedStr = new String(charArray);
            
            // If the sorted string is already a key, add the original string to the list
            if (!anagramMap.containsKey(sortedStr)) {
                anagramMap.put(sortedStr, new ArrayList<>());
            }
            anagramMap.get(sortedStr).add(str);
        }
        
        // Return the grouped anagrams as a list of lists
        return new ArrayList<>(anagramMap.values());
    }

    
}
