class Solution {
    public int calPoints(String[] operations) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (String op: operations) {
            switch(op) {
                case "+":
                    add(stack);
                    break;
                case "D":
                    recordDouble(stack);
                    break;
                case "C":
                    invalidate(stack);
                    break;
                default:
                    record(stack, op);
            }
        }

        // Return the sum of all the elements
        return sum(stack);
    }

    /**
     * Return the sum of all the elements in the stack
     */
    private static int sum(Deque<Integer> stack) {
        int sum = 0;
        while(!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }

    /**
     * Record a new score that is the sum of the previous two scores
     */
    private static void add(Deque<Integer> stack) {
        int y = stack.pop();
        int x = stack.pop();
        
        // Add the values and push the scores back on the stack
        stack.push(x);
        stack.push(y);
        stack.push(x+y);
    }

    /**
     * Record a new score that is the double of the previous score
     */
    private static void recordDouble(Deque<Integer> stack) {
        int x = stack.peek();
        stack.push(2*x);
    }

    /**
     * Invalidate the previous score, removing it from the record
     */
    private static void invalidate(Deque<Integer> stack) {
        // just remove the last result
        stack.pop();
    }

    /**
     * Record a new score of x
     */
    private static void record(Deque<Integer> stack, String x) {
        Integer val = Integer.parseInt(x);
        stack.push(val);
    }
}