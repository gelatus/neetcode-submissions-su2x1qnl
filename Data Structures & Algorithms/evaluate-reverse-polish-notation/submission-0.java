class Solution {
    public int evalRPN(String[] tokens) {
        Deque<String> stack = new ArrayDeque<>();
        int x, y, result;

        for (String token: tokens) {
            switch(token) {
                case "+":
                    y = Integer.parseInt(stack.pop());
                    x = Integer.parseInt(stack.pop());
                    result = x + y;
                    stack.push(Integer.toString(result));
                    break;
                case "-":
                    y = Integer.parseInt(stack.pop());
                    x = Integer.parseInt(stack.pop());
                    result = x - y;
                    stack.push(Integer.toString(result));
                    break;
                case "*":
                    y = Integer.parseInt(stack.pop());
                    x = Integer.parseInt(stack.pop());
                    result = x * y;
                    stack.push(Integer.toString(result));
                    break;
                case "/":
                    y = Integer.parseInt(stack.pop());
                    x = Integer.parseInt(stack.pop());
                    result = x / y;
                    stack.push(Integer.toString(result));
                    break;
                default:
                    stack.push(token);
            }
        }

        return Integer.parseInt(stack.pop());
    }
}
