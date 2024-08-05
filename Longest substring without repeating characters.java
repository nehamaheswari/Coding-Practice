class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> charSet = new HashSet<>();
        int left = 0; //left: The starting index of the current window.
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) { //For each character: Use right as the current index.
            char currentChar = s.charAt(right);

            // If the character is already in the set, remove characters from the left
            while (charSet.contains(currentChar)) {
                charSet.remove(s.charAt(left));
                left++;
            }

            // Add the current character to the set
            charSet.add(currentChar);
            // Update the maximum length
            maxLength = Math.max(maxLength, right - left + 1); 
          //The +1 is necessary because both left and right are inclusive indices. If left and right are at the same position, the length of the substring is 1, not 0.
        }

        return maxLength;
        
    }
}
