class Solution {
    public int search(int[] nums, int target) {
        int idx = -1;
        int l=0, r = nums.length;
        int mid = (r-l)/2;

        while (l < r) {
            if (target == nums[l]) {
                idx = l;
                break;
            } else if (target == nums[r-1]) {
                idx = r-1;
                break;
            } else if (target == nums[mid]) {
                idx = mid;
                break;
            } else if (target < nums[mid]) {
                r = mid;
            } else if (target > nums[mid]) {
                l = mid+1;
            } 
            mid = (l+r)/2;
        }

        return idx;

    }
}
