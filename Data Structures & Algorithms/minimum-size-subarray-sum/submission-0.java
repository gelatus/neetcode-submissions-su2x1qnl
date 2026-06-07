class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int curSum = 0, left = 0;
        int minLength = Integer.MAX_VALUE;

        for (int right=0; right < nums.length; right++) {
            curSum += nums[right];
            while (curSum >= target) {
                minLength = Math.min(minLength, right-left+1);
                curSum -= nums[left];
                left++;
            }
        }

        return (minLength == Integer.MAX_VALUE) ? 0 : minLength;
    }
}