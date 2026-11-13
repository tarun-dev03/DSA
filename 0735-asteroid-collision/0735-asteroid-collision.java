

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        for (int a : asteroids) {
            boolean exploded = false;

            // Collision only happens when:
            // top of stack is moving RIGHT (> 0) and current asteroid is moving LEFT (< 0)
            while (!st.isEmpty() && st.peek() > 0 && a < 0) {
                if (st.peek() < -a) {
                    // Top asteroid is smaller; it explodes, current 'a' keeps going!
                    st.pop();
                } else if (st.peek() == -a) {
                    // Both have equal size; both explode!
                    st.pop();
                    exploded = true;
                    break;
                } else {
                    // Top asteroid is bigger; current 'a' explodes!
                    exploded = true;
                    break;
                }
            }

            // If the incoming asteroid didn't explode, it survives and joins the stack
            if (!exploded) {
                st.push(a);
            }
        }

        // Convert the remaining surviving asteroids in the stack to an array
        int[] ans = new int[st.size()];
        for (int i = ans.length - 1; i >= 0; i--) {
            ans[i] = st.pop();
        }

        return ans;
    }
}