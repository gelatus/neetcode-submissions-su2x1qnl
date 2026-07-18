class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        // Ensure nums1 is the smaller array
        const vector<int>& A = (nums1.size() <= nums2.size()) ? nums1 : nums2;
        const vector<int>& B = (nums1.size() <= nums2.size()) ? nums2 : nums1;
        
        int m = A.size(), n = B.size();
        int total = m + n;
        int half = total / 2;

        int left = 0, right = m;
        while (true) {
            int i = (left + right) / 2;   // partition A
            int j = half - i;             // partition B

            int Aleft  = (i > 0) ? A[i - 1] : INT_MIN;
            int Aright = (i < m) ? A[i]     : INT_MAX;
            int Bleft  = (j > 0) ? B[j - 1] : INT_MIN;
            int Bright = (j < n) ? B[j]     : INT_MAX;

            if (Aleft <= Bright && Bleft <= Aright) {
                // Correct partition found
                if (total % 2 == 0) {
                    return (max(Aleft, Bleft) + min(Aright, Bright)) / 2.0;
                } else {
                    return min(Aright, Bright);
                }
            } else if (Aleft > Bright) {
                right = i - 1; // move partition left
            } else {
                left = i + 1;  // move partition right
            }
        }
    }
};
