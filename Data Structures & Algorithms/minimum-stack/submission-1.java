class MinStack {
    Deque<Integer> valStack = new ArrayDeque<>();
    Deque<Integer> minStack = new ArrayDeque<>();

    public MinStack() {
        
    }
    
    public void push(int val) {
        valStack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }
    
    public void pop() {
        Integer removed = valStack.pop();
        if (removed.equals(minStack.peek())) {
            minStack.pop();
        }
    }
    
    public int top() {
        return valStack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
