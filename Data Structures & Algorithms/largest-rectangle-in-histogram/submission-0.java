class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Deque<int[]> stack = new ArrayDeque<>(); // [index,height]

        for (int i=0; i < heights.length; i++) {
            int start = i;
            while (!stack.isEmpty() && stack.peek()[1] > heights[i]) {
                int[] r = stack.pop();
                maxArea = Math.max(maxArea, (i - r[0]) * r[1]);
                start = r[0];
            }
            stack.push(new int[]{start, heights[i]});
        }

        // Check the remaining entries in the stack
        for (int[] r: stack) {
            maxArea = Math.max(maxArea, r[1] * (heights.length - r[0]));
        }

        return maxArea;
    }
}
