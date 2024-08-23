/*Given a string expression representing an expression of fraction addition and subtraction, return the calculation result in string format.
The final result should be an irreducible fraction. If your final result is an integer, change it to the format of a fraction that has a denominator 1. 
So in this case, 2 should be converted to 2/1.*/

class Solution {
    public String fractionAddition(String expression) {
     int numerator = 0, denominator = 1;  // Start with a fraction of 0/1
        
        int i = 0, n = expression.length();
        while (i < n) {
            // Determine the sign of the next fraction
            int sign = 1;
            if (expression.charAt(i) == '+' || expression.charAt(i) == '-') {
                sign = expression.charAt(i) == '+' ? 1 : -1;
                i++;
            }
            
            // Parse the next fraction
            int num = 0;
            while (i < n && Character.isDigit(expression.charAt(i))) {
                num = num * 10 + (expression.charAt(i) - '0');
                i++;
            }
            num *= sign;
            
            i++; // skip '/'
            
            int denom = 0;
            while (i < n && Character.isDigit(expression.charAt(i))) {
                denom = denom * 10 + (expression.charAt(i) - '0');
                i++;
            }
            
            // Add the fraction num/denom to the current fraction
            numerator = numerator * denom + num * denominator;
            denominator *= denom;
            
            // Simplify the fraction
            int gcd = gcd(Math.abs(numerator), denominator);
            numerator /= gcd;
            denominator /= gcd;
        }
        
        return numerator + "/" + denominator;
    }

    // Helper function to find the Greatest Common Divisor (GCD) using Euclidean algorithm
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
