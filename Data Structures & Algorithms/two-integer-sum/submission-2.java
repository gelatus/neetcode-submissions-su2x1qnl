class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer,Integer> diffMap = new HashMap<>();

        // Populate the hashmap with the difference
        // diff = target - nums[i]

        for (int i=0; i < nums.length; ++i) {
            int diff = target - nums[i];
            Integer j = diffMap.get(diff);
            if (j != null) {
                result[0] = j;
                result[1] = i;
                break;
            }

            diffMap.put(nums[i],i);
        }

        return result;
    }
}
