import java.util.Stack;

class MyQueue {
    private Stack<Integer> input;
    private Stack<Integer> output;

    public MyQueue() {
        input = new Stack<>();
        output = new Stack<>();
    }
    
    public void push(int x) {
        // Always push new elements to the input stack
        input.push(x);
    }
    
    public int pop() {
        // Ensure the output stack has the front elements ready
        peek();
        return output.pop();
    }
    
    public int peek() {
        // If output stack is empty, transfer all elements from input stack
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }
        // The oldest element is now at the top of the output stack
        return output.peek();
    }
    
    public boolean empty() {
        // The queue is empty only if both stacks are empty
        return input.isEmpty() && output.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */