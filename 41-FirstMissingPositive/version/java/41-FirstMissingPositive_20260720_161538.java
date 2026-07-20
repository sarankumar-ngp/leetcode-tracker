// Last updated: 20/07/2026, 16:15:38
1class Solution {
2    public int firstMissingPositive(int[] nums) {
3        if (nums == null || nums.length == 0) {
4            return 1;
5        }
6        
7        int n = nums.length;
8        
9        // Cycle sort: Place each number in its correct index if possible
10        // e.g., the number 1 should go to index 0, 2 to index 1, etc.
11        for (int i = 0; i < n; i++) {
12            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
13                // Swap nums[i] to its target index position (nums[i] - 1)
14                int targetIndex = nums[i] - 1;
15                int temp = nums[i];
16                nums[i] = nums[targetIndex];
17                nums[targetIndex] = temp;
18            }
19        }
20        
21        // Find the first index where the number does not match its expected index mapping
22        for (int i = 0; i < n; i++) {
23            if (nums[i] != i + 1) {
24                return i + 1;
25            }
26        }
27        
28        // If all positions are correctly matched, the missing number is n + 1
29        return n + 1;
30    }
31}