// Last updated: 20/07/2026, 16:09:51
1class Solution {
2    public void nextPermutation(int[] nums) {
3        if (nums == null || nums.length <= 1) {
4            return;
5        }
6
7        // 1. Find the first decreasing element from the right
8        int i = nums.length - 2;
9        while (i >= 0 && nums[i] >= nums[i + 1]) {
10            i--;
11        }
12
13        // 2. If the entire array is not decreasing, find the successor to swap with
14        if (i >= 0) {
15            int j = nums.length - 1;
16            while (nums[j] <= nums[i]) {
17                j--;
18            }
19            swap(nums, i, j);
20        }
21
22        // 3. Reverse the elements after the breakpoint i
23        reverse(nums, i + 1, nums.length - 1);
24    }
25
26    private void swap(int[] nums, int i, int j) {
27        int temp = nums[i];
28        nums[i] = nums[j];
29        nums[j] = temp;
30    }
31
32    private void reverse(int[] nums, int start, int end) {
33        while (start < end) {
34            swap(nums, start, end);
35            start++;
36            end--;
37        }
38    }
39}