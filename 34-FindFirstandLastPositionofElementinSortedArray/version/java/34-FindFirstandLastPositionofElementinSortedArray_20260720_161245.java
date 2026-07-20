// Last updated: 20/07/2026, 16:12:45
1class Solution {
2    public int[] searchRange(int[] nums, int target) {
3        int[] result = new int[]{-1, -1};
4        
5        result[0] = findBound(nums, target, true);  // Find first position
6        result[1] = findBound(nums, target, false); // Find last position
7        
8        return result;
9    }
10
11    private int findBound(int[] nums, int target, boolean isFirst) {
12        int left = 0;
13        int right = nums.length - 1;
14        int bound = -1;
15
16        while (left <= right) {
17            int mid = left + (right - left) / 2;
18
19            if (nums[mid] == target) {
20                bound = mid; // Record the match index
21                if (isFirst) {
22                    right = mid - 1; // Keep scanning left to find earlier occurrences
23                } else {
24                    left = mid + 1;  // Keep scanning right to find later occurrences
25                }
26            } else if (nums[mid] < target) {
27                left = mid + 1;
28            } else {
29                right = mid - 1;
30            }
31        }
32
33        return bound;
34    }
35}