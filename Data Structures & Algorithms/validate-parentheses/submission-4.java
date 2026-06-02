class Solution {
    public boolean isValid(String s) {
        // Create a stack using Deque
        Deque<Character> stack = new ArrayDeque<>();

        for (char c: s.toCharArray()) {
            switch(c) {
                case '(':
                case '{':
                case '[':
                    stack.push(c);
                    break;
                case ')':
                    if (stack.peek() == null || stack.pop() != '(')
                        return false;
                    break;
                case '}':
                    if (stack.peek() == null || stack.pop() != '{')
                        return false;
                    break;
                case ']':
                    if (stack.peek() == null || stack.pop() != '[')
                        return false;
                    break;
                default:
                    return false; // any invalid character
            }
        }

        return stack.isEmpty();
    }
}
