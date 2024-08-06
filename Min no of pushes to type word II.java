/*You are given a string word containing lowercase English letters.
Telephone keypads have keys mapped with distinct collections of lowercase English letters, which can be used to form words by pushing them.
For example, the key 2 is mapped with ["a","b","c"], we need to push the key one time to type "a", two times to type "b", and three times to type "c" .
It is allowed to remap the keys numbered 2 to 9 to distinct collections of letters.
The keys can be remapped to any amount of letters, but each letter must be mapped to exactly one key. 
You need to find the minimum number of times the keys will be pushed to type the string word.
Return the minimum number of pushes needed to type word after remapping the keys.*/

class Solution {
    public int minimumPushes(String word) {
        // Create an array to store the frequency of each letter
        int[] freq = new int[26];
        
        // Count the frequency of each letter in the word
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }
        
        // Sort the frequencies in ascending order
        Arrays.sort(freq);
        
        // Initialize variables to keep track of the total presses and the current multiplier
        int totalPresses = 0;
        int multiplier = 1;
      //The multiplier represents the number of presses required for each group of 8 characters, starting with 1 press for the first group, 2 presses for the next group, and so on.
        
        // Assign letters to keys, starting from the most frequent
        for (int i = 25; i >= 0; i--) {
            // If the frequency is 0, break the loop
            if (freq[i] == 0) break;//when no more letters are left.
            
            // If we've reached a new key, increment the multiplier
            if ((25 - i) % 8 == 0 && i != 25) {
                multiplier++; //Each set of up to 8 characters uses one more press than the previous set.
            }
            
            // Calculate the total presses for the current letter
            totalPresses += freq[i] * multiplier;
        }
        
        // Return the total number of key presses
        return totalPresses;
    }
}
