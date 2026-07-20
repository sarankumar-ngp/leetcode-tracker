// Last updated: 20/07/2026, 15:47:43
1class Solution {
2    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
3        // Ensure nums1 is the smaller array to minimize the binary search range
4        if (nums1.length > nums2.length) {
5            return findMedianSortedArrays(nums2, nums1);
6        }
7        
8        int m = nums1.length;
9        int n = nums2.length;
10        int left = 0;
11        int right = m;
12        int totalLeft = (m + n + 1) / 2;
13        
14        while (left <= right) {
15            int i = left + (right - left) / 2; // Partition index in nums1
16            int j = totalLeft - i;             // Partition index in nums2
17            
18            // Boundary values around the partitions
19            int nums1LeftMax = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
20            int nums1RightMin = (i == m) ? Integer.MAX_VALUE : nums1[i];
21            
22            int nums2LeftMax = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
23            int nums2RightMin = (j == n) ? Integer.MAX_VALUE : nums2[j];
24            
25            // Correct partition found
26            if (nums1LeftMax <= nums2RightMin && nums2LeftMax <= nums1RightMin) {
27                // If total length is odd
28                if ((m + n) % 2 != 0) {
29                    return Math.max(nums1LeftMax, nums2LeftMax);
30                }
31                // If total length is even
32                return (Math.max(nums1LeftMax, nums2LeftMax) + Math.min(nums1RightMin, nums2RightMin)) / 2.0;
33            } 
34            else if (nums1LeftMax > nums2RightMin) {
35                // Too many elements on the left side of nums1; move partition left
36                right = i - 1;
37            } 
38            else {
39                // Too few elements on the left side of nums1; move partition right
40                left = i + 1;
41            }
42        }
43        
44        return 0.0;
45    }
46}