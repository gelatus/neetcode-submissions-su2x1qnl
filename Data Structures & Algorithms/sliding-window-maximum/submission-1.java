class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> results = new ArrayList<>();
        int maxVal = Integer.MIN_VALUE;
        int left = 0, right = 0;

        // Create a PriorityQueue configured as a Max-Heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // Initialize the first window
        while (right < k) {
            maxHeap.offer(nums[right++]);
        }
        maxVal = maxHeap.peek();

        // slide the window across the array
        while (right < nums.length) {
            results.add(maxVal);

            // Remove the element that is sliding out of the window
            maxHeap.remove(nums[left]);

            // Add the new element sliding into the window
            maxHeap.offer(nums[right]);
            maxVal = maxHeap.peek();

            left++;
            right++;
        }
        // Add the maximum for the last window
        results.add(maxVal);

        return results.stream().mapToInt(i -> i).toArray();        
    }
}
