class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] results = new int[temperatures.length];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i=temperatures.length-1; i>=0; i--) {
            // Remove elements from the stack if
            // they are smaller than the current one
            // Remove elements from the stack if
            // they are smaller than the current one
            while(!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop();
            }

            // If stack is empty, there are no larger elements
            if (stack.isEmpty()) {
                results[i] = 0;
            } else {
                results[i] = stack.peek() - i;
            }

            stack.push(i);
        }

        return results;
    }
}
