class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        // Edge case: Not enough total flowers in the garden
        if ((long) m * k > bloomDay.length) {
            return -1;
        }

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        for (int i = 0; i < bloomDay.length; i++) {
            low = Math.min(low, bloomDay[i]);
            high = Math.max(high, bloomDay[i]);
        }

        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canMake(bloomDay, m, k, mid)) {
                ans = mid;
                high = mid - 1; // Try to find an earlier (smaller) day
            } else {
                low = mid + 1;  // Need to wait for more flowers to bloom
            }
        }
        return ans;
    }

    private boolean canMake(int[] bloomDay, int m, int k, int day) {
        int flowers = 0;
        int bouquets = 0;

        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= day) {
                flowers++;
            } else {
                // Unbloomed flower breaks the adjacent streak
                flowers = 0;
            }

            // Collected k adjacent flowers -> make 1 bouquet
            if (flowers == k) {
                bouquets++;
                flowers = 0; // Reset for the next bouquet
            }

            // Made all m required bouquets
            if (bouquets >= m) {
                return true;
            }
        }
        return false;
    }
}