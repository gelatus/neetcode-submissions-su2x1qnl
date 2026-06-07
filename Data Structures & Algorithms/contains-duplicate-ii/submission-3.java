class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k == 0)
            return false;

        int N = nums.length;
        for (int left=0; left<N-1; left++) {
            for (int right=left+1; right<=Math.min(left+k,N-1); right++) {
                if (nums[left] == nums[right]) {
                    return true;
                }
            }
        }

        return false;
    }
}