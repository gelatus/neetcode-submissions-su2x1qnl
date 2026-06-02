class Solution {
    public boolean isValid(String s) {
        // If string length is odd, it's automatically invalid
        if ((s.length() % 2) != 0) 
            return false;
            
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
