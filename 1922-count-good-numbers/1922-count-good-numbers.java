class Solution {

    static final long MOD = 1_000_000_007;

    public int countGoodNumbers(long n) {

        long evenPositions = (n + 1) / 2;
        long oddPositions = n / 2;

        long a = power(5, evenPositions);
        long b = power(4, oddPositions);

        return (int)((a * b) % MOD);
    }

    private long power(long x ,long n ){
        if(n == 0 ){
            return 1;
        }
        long half = power(x,n/2);
        if(n % 2 == 0){
            return (half * half) % MOD;
        }
        else{
            return (half * half * x) % MOD;
        }
        
    }
}