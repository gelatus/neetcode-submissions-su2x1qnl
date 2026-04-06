class Solution {
    public boolean isAnagram(String s, String t) {
        // First check if the strings are the same size
        if (s.length() != t.length())
            return false;

        // Add characters and their counts for the first string
        Map<Character,Integer> charMap = new HashMap<>();
        for (int i=0; i < s.length(); ++i) {
            char c = s.charAt(i);
            Integer count = charMap.get(c);
            if (count != null) {
                charMap.put(c, count+1); 
            } else {
                charMap.put(c, 1);
            }
        }

        // Now check the characters of the second string
        for (int i=0; i < t.length(); ++i) {
            char c = t.charAt(i);
            Integer count = charMap.get(c);
            if (count == null)
                return false;

            if (count-1 < 0) 
                return false;

            charMap.put(c,count-1);
        }

        return true;
    }
}
