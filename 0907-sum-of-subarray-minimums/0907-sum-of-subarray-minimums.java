import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int MOD = 1_000_000_007;

        // left[i]  = distance to the previous element <= arr[i]
        // right[i] = distance to the next element < arr[i]
        int[] left = new int[n];
        int[] right = new int[n];

        // Monotonic stack storing indices
        Deque<Integer> stack = new ArrayDeque<>();

        // 1. Calculate left distances (Previous Less or Equal)
        for (int i = 0; i < n; i++) {
            // Pop elements strictly greater than arr[i]
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            // If stack is empty, no smaller element exists on the left
            left[i] = stack.isEmpty() ? (i + 1) : (i - stack.peek());
            stack.push(i);
        }

        stack.clear();

        // 2. Calculate right distances (Next Less)
        for (int i = n - 1; i >= 0; i--) {
            // Pop elements greater than or equal to arr[i] (strict inequality here)
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            // If stack is empty, no smaller element exists on the right
            right[i] = stack.isEmpty() ? (n - i) : (stack.peek() - i);
            stack.push(i);
        }

        // 3. Accumulate total contribution
        long totalSum = 0;
        for (int i = 0; i < n; i++) {
            long count = (long) left[i] * right[i];
            long contribution = (count % MOD) * arr[i] % MOD;
            totalSum = (totalSum + contribution) % MOD;
        }

        return (int) totalSum;
    }
}