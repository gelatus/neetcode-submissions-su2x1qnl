class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k == 0)
            return false;

        Set<Integer> kwin = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (kwin.contains(nums[i]))
                return true;

            kwin.add(nums[i]);

            if (kwin.size() == k+1) {
                kwin.remove(nums[i-k]);
            }
        }

        return false;
    }
}