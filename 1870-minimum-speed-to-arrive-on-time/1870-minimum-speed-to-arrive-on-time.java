class Solution {
    private boolean canReachOnTime(int[] dist, double hour, int speed) {
        double totalTime = 0.0;
        int n = dist.length;
        
        // 1. All trains EXCEPT the last one must wait for the next integer hour (round up)
        for (int i = 0; i < n - 1; i++) {
            totalTime += Math.ceil((double) dist[i] / speed); // Blank 1
        }
        
        // 2. The VERY LAST train doesn't wait afterwards (exact decimal time)
        totalTime += (double) dist[n - 1] / speed;            // Blank 2
        
        // 3. Check if we reached within the allowed 'hour'
        return totalTime <= hour;                             // Blank 3
    }

    public int minSpeedOnTime(int[] dist, double hour) {
        int low = 1;
        int high = 10000000; // 10^7
        int ans = -1;        // Default -1 if it's impossible to arrive on time
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (canReachOnTime(dist, hour, mid)) {
                ans = mid;       // Speed 'mid' works! Save it.
                high = mid - 1;  // Try to find a SMALLER speed (go LEFT)
            } else {
                low = mid + 1;   // Speed 'mid' was too slow! Try a FASTER speed (go RIGHT)
            }
        }
        return ans;
    }
}