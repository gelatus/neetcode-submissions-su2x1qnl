class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int sol = -1;
        
        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (mid == 0 || nums[mid] < nums[mid-1]) {
                sol = nums[mid];
                break;
            } else {
                right = mid;
            }
        }

        return sol;
    }
}
