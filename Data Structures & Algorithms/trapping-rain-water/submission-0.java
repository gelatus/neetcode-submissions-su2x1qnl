class Solution {
    public int trap(int[] height) {
        // pre-calculate maximum heights
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        int lm=0, rm=0;
        for (int i=0; i<height.length; ++i) {
            lm = Math.max(lm,height[i]);
            leftMax[i] = lm;

            int ridx = height.length - 1 - i;
            rm = Math.max(rm,height[ridx]);
            rightMax[ridx] = rm;
        }

        int total = 0;
        for (int i=1; i<height.length; ++i) {
            total  += Math.min(leftMax[i],rightMax[i]) - height[i];
        }

        return total;
    }
}
