class Solution {
    public boolean hasDuplicate(int[] nums) {
        if (nums == null || nums.length == 0)
            return false;

        Set<Integer> numset = new HashSet<>();
        for (int num: nums) {
            if (numset.contains(num)) 
                return true;
            numset.add(num);
        }

        return false;

    }
}