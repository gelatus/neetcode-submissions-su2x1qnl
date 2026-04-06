class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.isEmpty()) return false;
        int head = 0;
        int tail = s.length() - 1;

        while (head < tail) {
            char left = s.charAt(head);
            char right = s.charAt(tail);
            if (!Character.isLetterOrDigit(left)) {
                head++;
                continue;
            }

            if (!Character.isLetterOrDigit(right)) {
                tail--;
                continue;
            }

            if (Character.toLowerCase(left) != Character.toLowerCase(right)) {
                return false;
            }

            head++;
            tail--;
        }

        return true;
    }
}
