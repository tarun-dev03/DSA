class Solution {
    public int fib(int n) {
        return sol(n);
    }

    public int sol(int n) {

        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        int ans = sol(n - 1) + sol(n - 2);

        return ans;
    }
}