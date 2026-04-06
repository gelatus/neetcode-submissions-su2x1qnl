class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // sort the array
        Arrays.sort(nums);

        List<List<Integer>> results = new ArrayList<>();

        // Loop over each element
        // starting from the back 
        // We are looking for indices that match
        // nums[i] + nums[j] + nums[k] == 0
        // or
        // nums[i] + nums[j] == -nums[k]
        for (int k=nums.length-1; k>1; k--) {
            if (k<nums.length-1 && nums[k] == nums[k+1]) continue;
            int j=k-1;
            int i=0;

            while(i<j) {
                int sum = nums[i] + nums[j];
                int target=-nums[k];

                if (sum == target) {
                    List l = Arrays.asList(nums[i],nums[j],nums[k]);
                    results.add(l);
                     i++; j--;
                    while (i<j && nums[i] == nums[i-1]) i++;
                    while (i<j && nums[j] == nums[j+1]) j--;

                } else if (sum > target) {
                    j--;
                } else if (sum < target) {
                    i++;
                }
            }
        }

        return results;
        
    }
}
