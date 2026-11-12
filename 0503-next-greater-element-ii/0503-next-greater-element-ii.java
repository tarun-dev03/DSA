import java.util.Stack;

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] greater = new int[n];
        Stack<Integer> st = new Stack<>();

        // Loop from (2 * n - 1) down to 0 to simulate the circular wrap-around
        for (int i = 2 * n - 1; i >= 0; i--) {
            // Use (i % n) to wrap the index safely inside [0, n - 1]
            int current = nums[i % n];

            // Pop elements that are smaller than or equal to the current element
            while (!st.isEmpty() && st.peek() <= current) {
                st.pop();
            }

            // We only need to record answers during the second pass (when i < n)
            if (i < n) {
                greater[i] = st.isEmpty() ? -1 : st.peek();
            }

            // Push current element onto the stack
            st.push(current);
        }

        return greater;
    }
}