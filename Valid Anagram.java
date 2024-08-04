/*Given two strings s and t, return true if t is an anagram of s, and false otherwise.
An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.*/
//Time Complexity: O(n), where n is the length of the strings s and t.
//Space Complexity: O(1), as only a fixed-size array and a few variables are used.

class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        int [] alpha = new int[26];

        for(char c : s.toCharArray()) {
            alpha[c - 'a'] += 1;
        }
      //c - 'a' calculates the index for the character c in the alpha array.

        for(char c : t.toCharArray()) {
            alpha[c - 'a'] -= 1;
        }

        for(int a : alpha){ // if s and t are anagrams, the alpha array should contain all zeros.
            if (a != 0)
                return false;
        }
        return true;
    }
}


