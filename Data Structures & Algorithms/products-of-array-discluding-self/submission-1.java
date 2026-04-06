class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        // Iterate from left to right
        result[0] = 1;
        for (int i=1; i < nums.length; i++) {
            result[i] = nums[i-1]*result[i-1];
        }

        // Iterate from right to left
        int prod=1;
        for (int i=nums.length-1; i>=0; i--) {
            result[i] = result[i]*prod;
            prod *= nums[i];
        }

        return result;
    }
}  
