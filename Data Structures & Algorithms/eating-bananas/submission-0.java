class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Arrays.stream(piles).max().getAsInt();
        int res = right;

        while (left <= right) {
            int k = (left + right) / 2;
            int hours = 0;

            for (int p: piles) {
                hours += (int) Math.ceil((double)p/k);
            }

            if (hours <= h) {
                res = Math.min(res, k);
                right = k -1;
            } else {
                left = k + 1;
            }
        }

        return res;
    }
}
