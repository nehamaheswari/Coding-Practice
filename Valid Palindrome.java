/*A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, 
it reads the same forward and backward. Alphanumeric characters include letters and numbers.
Given a string s, return true if it is a palindrome, or false otherwise.*/

class Solution {
     public static boolean isPalindrome(String s) {
        // Step 1: Convert the string to lowercase and remove non-alphanumeric characters
        StringBuilder n = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                n.append(Character.toLowerCase(c));
            }
        }

        // Step 2: Check if the cleaned string is a palindrome
        int left = 0;
        int right = n.length() - 1;

        while (left < right) {
            if (n.charAt(left) != n.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
