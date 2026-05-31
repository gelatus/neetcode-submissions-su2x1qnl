class Solution {

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] count = new int[26];
        for (char c : s1.toCharArray()) {
            count[c - 'a']++;
        }

        int matches = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] == 0) matches++;
        }

        for (int i = 0; i < s2.length(); i++) {
            int idx = s2.charAt(i) - 'a';

            // If a slot was 0, decrement matches
            if (count[idx] == 0) matches--;

            count[idx]--;

            // If a slot becomes 0, increment matches
            if (count[idx] == 0) matches++;

            if (i >= s1.length()) {
                idx = s2.charAt(i - s1.length()) - 'a';

                // If a slot was 0, decrement matches
                if (count[idx] == 0) matches--;

                count[idx]++;

                // If a slot becomes 0, increment matches
                if (count[idx] == 0) matches++;
            }

            if (matches == 26) {
                return true;
            }
        }
        return false;
    }

    private boolean allZero(int[] count) {
        for (int value : count) {
            if (value != 0) {
                return false;
            }
        }
        return true;
    }

}
