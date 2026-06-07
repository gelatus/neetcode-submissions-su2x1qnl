class Solution {
    public int maxTurbulenceSize(int[] arr) {
        // Need at least two elements to compare
        if (arr.length < 2) return arr.length; 
        
        int left = 0, maxLen = 0, cmp=0;

        for (int right = 1; right < arr.length; right++) {
            // Save previous comparison result
            int prevCmp = cmp;

            // Get current comparison result
            cmp = Integer.compare(arr[right], arr[right-1]);

            if (cmp == 0) {
                // No change, breaks turbulence
                left = right;
            } else if (right == 1) {
                // First iteration, just continue
            } else if ((cmp * prevCmp) != -1) {
                // Pattern didn't alternate, reset window
                left = right -1;
                
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}