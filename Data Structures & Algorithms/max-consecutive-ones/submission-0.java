class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int curCount = 0, maxCount = 0;
        for (int num: nums) {
            if (num == 1) {
                curCount++;
                maxCount = Math.max(maxCount,curCount);
            } else {
                curCount = 0;
            }
        }

        return maxCount;
        
    }
}