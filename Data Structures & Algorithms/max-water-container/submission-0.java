class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length -1;
        int maxArea = 0;

        while (left < right) {
            int h = Math.min(heights[left], heights[right]);
            int w = right - left;
            int area = h*w;
            if (area > maxArea) maxArea = area;

            if (heights[left] <= heights[right]) {
                ++left;
            } else if (heights[left] > heights[right]) {
                --right;
            }
        }

        return maxArea;
    }
}
