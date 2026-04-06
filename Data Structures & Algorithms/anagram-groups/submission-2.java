class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> freqMap = new HashMap<>();

        // Loop over the strs array and add to
        // the frequency map
        for (String str: strs) {
            String key = getKey(str);
            List<String> strList = freqMap.get(key);
            if (strList == null) {
                strList = new ArrayList<>();
                freqMap.put(key, strList);
            }

            strList.add(str);
        }

        // Flatten the map and return results
        return new ArrayList<>(freqMap.values());
    }

    /**
     * Get a frequency key for the given string
     */
    private String getKey(String str) {
        int[] freq = new int[26];
        for (char c: str.toCharArray()) {
            freq[c - 'a']++;
        }
        return Arrays.toString(freq);
    }
}
