import java.util.Stack;

class StockSpanner {
    // 1. Declare stack at the class level so 'next' can use it
    // Each entry holds: [price, span]
    private Stack<int[]> st;

    public StockSpanner() {
        st = new Stack<>();
    }
    
    public int next(int price) {
        int span = 1; // Base span for today alone

        // While past days have a price <= today's price, absorb their spans
        while (!st.isEmpty() && st.peek()[0] <= price) {
            span += st.pop()[1];
        }

        // Push today's price along with its accumulated span
        st.push(new int[]{price, span});

        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */