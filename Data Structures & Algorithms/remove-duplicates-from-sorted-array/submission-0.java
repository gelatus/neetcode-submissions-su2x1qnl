class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 1;
        int cur = 0;
        int prev = nums[0];

        for (int i=1; i<nums.length; ++i) {
            int val = nums[i];
            if (val != prev) {
                k++;
                cur++;
                nums[cur] = val;
                prev = val; 
            }
        }

        return k;
    }
}