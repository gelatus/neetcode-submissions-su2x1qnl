class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int curMax = 0, curMin = 0;
        int globalMax = nums[0], globalMin = nums[0], sum = 0;

        for (int n: nums) {
            curMax = Math.max(curMax + n, n);
            globalMax = Math.max(globalMax, curMax);
            curMin = Math.min(curMin + n, n);
            globalMin = Math.min(globalMin, curMin);
            sum += n;
        }

        return (globalMax > 0) ? Math.max(globalMax, sum - globalMin) : globalMax;
    }

}