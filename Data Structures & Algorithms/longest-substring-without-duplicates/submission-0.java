class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) return 0;
        int longest = 1;
        int left = 0;
        Set<Character> window = new HashSet<>();
        for (int right = 0; right < s.length(); ++right) {
            while (window.contains(s.charAt(right))) {
                window.remove(s.charAt(left));
                ++left;
            }
            window.add(s.charAt(right));
            int len = right - left + 1;
            longest = Math.max(len, longest);
        }

        return longest;
    }
}
