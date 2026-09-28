class Solution {
    public int secondHighest(String s) {
        int max = -1;
        int second = -1;

        for (int i = 0; i < s.length(); i++) {

            if (Character.isDigit(s.charAt(i))) {

                int digit = s.charAt(i) - '0';

                if (digit > max) {
                    second = max;
                    max = digit;
                } 
                else if (digit > second && digit < max) {
                    second = digit;
                }
            }
        }

        return second;
    }
}