class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        total = len(nums1) + len(nums2)
        half = total // 2

        # Make sure A is the smaller array
        arr_a, arr_b = nums1, nums2
        if len(arr_a) > len(arr_b):
            arr_a, arr_b = arr_b, arr_a

        left, right = 0, len(arr_a)

        while left <= right:
            mid_a = (left + right) // 2
            mid_b = half - mid_a

            a_left = arr_a[mid_a - 1] if mid_a > 0 else float("-inf")
            a_right = arr_a[mid_a] if mid_a < len(arr_a) else float("inf")
            b_left = arr_b[mid_b - 1] if mid_b > 0 else float("-inf")
            b_right = arr_b[mid_b] if mid_b < len(arr_b) else float("inf")

            if a_left <= b_right and b_left <= a_right:
                # odd
                if (total % 2):
                    return min(a_right, b_right)
                # even
                else:
                    return (max(a_left, b_left) + min(a_right, b_right)) / 2
            elif a_left > b_right:
                right = mid_a - 1
            else:
                left =mid_a + 1
        
        # should never get here
        return -1



        
        