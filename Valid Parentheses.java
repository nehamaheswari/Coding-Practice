/*Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
An input string is valid if:
Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.*/

class Solution {
    public boolean isValid(String s) {
         // Stack to keep track of opening brackets
        Stack<Character> stack = new Stack<>();

        // Iterate through each character in the string
        for (char c : s.toCharArray()) {
            // If the character is an opening bracket, push it onto the stack
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } 
            // If the character is a closing bracket, check for a matching opening bracket
            else {
                if (stack.isEmpty()) {
                    return false; // No matching opening bracket
                }
                
                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                    (c == '}' && top != '{') ||
                    (c == ']' && top != '[')) {
                    return false; // Mismatched pair
                }
            }
        }

        // If the stack is empty, all brackets were matched; otherwise, it's invalid
        return stack.isEmpty();
    }
        
    
}
