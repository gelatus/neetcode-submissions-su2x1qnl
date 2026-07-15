class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int targetIdx = -1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] == target) {
                targetIdx = mid;
                break;
            }

            if (nums[mid] > nums[right]) {
                // pivot is on the right, left side is sorted.
                if (nums[left] <= target && target < nums[mid]) {
                    // target is on the left
                    right = mid - 1;
                } else {
                    // target is on the right
                    left = mid + 1;
                }
            } else {
                // pivot is on the left, right side is sorted
                if (nums[mid] < target && target <= nums[right]) {
                    // target is on the right
                    left = mid + 1;
                } else {
                    // target is on the left
                    right = mid - 1;
                }
            }            
        }

        return targetIdx;
    }
}
