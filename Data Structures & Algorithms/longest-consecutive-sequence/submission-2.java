class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> unique = new HashSet<>();
        int longest=0;

        for (int n:nums) {
            unique.add(n);
        }

        for (int n: unique) {

            if ( !unique.contains(n-1) ) {
                int curNum = n;
                int curStreak = 1;

                while (unique.contains(curNum+1)) {
                    curNum++;
                    curStreak++;
                }

                if (longest < curStreak) longest = curStreak;
            }
        }

        return longest;
    }
}
