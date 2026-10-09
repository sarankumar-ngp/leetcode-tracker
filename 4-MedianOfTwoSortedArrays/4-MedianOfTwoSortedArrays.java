// Last updated: 09/10/2026, 09:26:05
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Ensure nums1 is the smaller array to minimize the binary search range
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        
        int m = nums1.length;
        int n = nums2.length;
        int left = 0;
        int right = m;
        int totalLeft = (m + n + 1) / 2;
        
        while (left <= right) {
            int i = left + (right - left) / 2; // Partition index in nums1
            int j = totalLeft - i;             // Partition index in nums2
            
            // Boundary values around the partitions
            int nums1LeftMax = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            int nums1RightMin = (i == m) ? Integer.MAX_VALUE : nums1[i];
            
            int nums2LeftMax = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int nums2RightMin = (j == n) ? Integer.MAX_VALUE : nums2[j];
            
            // Correct partition found
            if (nums1LeftMax <= nums2RightMin && nums2LeftMax <= nums1RightMin) {
                // If total length is odd
                if ((m + n) % 2 != 0) {
                    return Math.max(nums1LeftMax, nums2LeftMax);
                }
                // If total length is even
                return (Math.max(nums1LeftMax, nums2LeftMax) + Math.min(nums1RightMin, nums2RightMin)) / 2.0;
            } 
            else if (nums1LeftMax > nums2RightMin) {
                // Too many elements on the left side of nums1; move partition left
                right = i - 1;
            } 
            else {
                // Too few elements on the left side of nums1; move partition right
                left = i + 1;
            }
        }
        
        return 0.0;
    }
}