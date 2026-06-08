class Solution {
    public int[] replaceElements(int[] arr) {
        // If the array only has a single element, don't need to do anything
        if (arr.length == 1) {
            arr[0] = -1;
            return arr;
        };

        int curMax = arr[arr.length-1];
        arr[arr.length-1] = -1;
        for (int i = arr.length-2; i>=0; i--) {
            int curVal = arr[i];
            arr[i] = curMax;
            curMax = Math.max(curMax,curVal);
        }

        return arr;
    }
}