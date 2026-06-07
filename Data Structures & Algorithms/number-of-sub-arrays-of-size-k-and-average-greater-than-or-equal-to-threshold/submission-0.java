class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int curSum = 0;
        int numValid = 0;

        // Get the average of the first window
        for (int i=0; i<k; i++) {
            curSum += arr[i];
        }

        if ((curSum / k) >= threshold) numValid++;

        // Now start sliding the window to the right
        for (int j=k; j<arr.length; j++) {
            // Remove the element that just fell out of the window
            curSum -= arr[j-k];

            // Add the new element to the window
            curSum += arr[j];

            // Check if the average is >= threshold
            if ((curSum / k) >= threshold) numValid++;
        }

        return numValid;
    }
}