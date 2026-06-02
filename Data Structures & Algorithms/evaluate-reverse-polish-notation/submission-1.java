class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        int x, y, result;

        for (String token: tokens) {
            switch(token) {
                case "+":
                    y = stack.pop();
                    x = stack.pop();
                    stack.push(x + y);
                    break;
                case "-":
                    y = stack.pop();
                    x = stack.pop();
                    stack.push(x - y);
                    break;
                case "*":
                    y = stack.pop();
                    x = stack.pop();
                    stack.push(x * y);
                    break;
                case "/":
                    y = stack.pop();
                    x = stack.pop();
                    stack.push(x / y);
                    break;
                default:
                    stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }
}
