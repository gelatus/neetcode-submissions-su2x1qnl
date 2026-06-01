class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        int[] count = new int[128];
        for (char c : t.toCharArray()) {
            count[c]++;
        }
        int left = 0, right = 0, minLeft = 0, minLen = Integer.MAX_VALUE, required = t.length();
        while (right < s.length()) {
            if (count[s.charAt(right)] > 0) {
                required--;
            }
            count[s.charAt(right)]--;
            right++;
            while (required == 0) {
                if (right - left < minLen) {
                    minLeft = left;
                    minLen = right - left;
                }
                count[s.charAt(left)]++;
                if (count[s.charAt(left)] > 0) {
                    required++;
                }
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLen);    }
}
