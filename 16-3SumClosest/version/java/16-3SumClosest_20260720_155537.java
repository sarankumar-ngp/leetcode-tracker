// Last updated: 20/07/2026, 15:55:37
1import java.util.Arrays;
2
3class Solution {
4    public int threeSumClosest(int[] nums, int target) {
5        // Sort the array to utilize the two-pointer approach
6        Arrays.sort(nums);
7        
8        // Initialize with the sum of the first three elements
9        int closestSum = nums[0] + nums[1] + nums[2];
10        
11        for (int i = 0; i < nums.length - 2; i++) {
12            int left = i + 1;
13            int right = nums.length - 1;
14            
15            while (left < right) {
16                int currentSum = nums[i] + nums[left] + nums[right];
17                
18                // If we find an exact match to the target, return it immediately
19                if (currentSum == target) {
20                    return currentSum;
21                }
22                
23                // If the current sum is closer to the target than our previous closest sum, update it
24                if (Math.abs(target - currentSum) < Math.abs(target - closestSum)) {
25                    closestSum = currentSum;
26                }
27                
28                // Move pointers based on how the current sum compares to the target
29                if (currentSum < target) {
30                    left++; // We need a larger sum
31                } else {
32                    right--; // We need a smaller sum
33                }
34            }
35        }
36        
37        return closestSum;
38    }
39}