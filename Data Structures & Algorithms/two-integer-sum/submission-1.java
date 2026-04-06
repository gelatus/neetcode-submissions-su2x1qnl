class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> diffMap = new HashMap<>();

        // Populate the hashmap with the difference
        // diff = target - nums[i]

        for (int i=0; i < nums.length; ++i) {
            int diff = target - nums[i];
            Integer j = diffMap.get(diff);
            if (j != null) {
                return new int[]{j,i};
            }

            diffMap.put(nums[i],i);
        }

        return new int[0];
    }
}
