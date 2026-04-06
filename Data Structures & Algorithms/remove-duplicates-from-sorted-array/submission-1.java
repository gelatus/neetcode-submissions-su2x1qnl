class Solution {
    public int removeDuplicates(int[] nums) {
        int iwrite = 1;

        for (int iread = 1; iread < nums.length; ++iread) {
            if (nums[iread] != nums[iread-1]) {
                nums[iwrite] = nums[iread];
                ++iwrite;
            }
        }

        return iwrite;
    }
}