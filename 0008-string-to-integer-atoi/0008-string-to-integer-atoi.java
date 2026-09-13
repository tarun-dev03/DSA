class Solution {

    public int myAtoi(String s) {
        int i = 0;

        // Skip leading spaces
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }

        // Check sign
        int sign = 1;

        if (i < s.length() && s.charAt(i) == '-') {
            sign = -1;
            i++;
        } 
        else if (i < s.length() && s.charAt(i) == '+') {
            i++;
        }

        return helper(s, i, 0, sign);
    }

    private int helper(String s, int i, int result, int sign) {

        // Base case
        if (i == s.length() || !Character.isDigit(s.charAt(i))) {
            return result * sign;
        }

        int digit = s.charAt(i) - '0';

        // Overflow check
        if (result > (Integer.MAX_VALUE - digit) / 10) {
            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }

        // Recursive call
        return helper(
            s,
            i + 1,
            result * 10 + digit,
            sign
        );
    }
}