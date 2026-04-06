class Solution {
    public int removeElement(int[] nums, int val) {
        int iwrite=0;
        for (int iread=0; iread<nums.length; ++iread) {
            if (nums[iread] != val) {
                nums[iwrite++] = nums[iread];
            }
        }

        return iwrite;
    }
}