// Last updated: 20/07/2026, 15:58:47
1import java.util.ArrayList;
2import java.util.Arrays;
3import java.util.List;
4
5class Solution {
6    public List<List<Integer>> fourSum(int[] nums, int target) {
7        List<List<Integer>> result = new ArrayList<>();
8        if (nums == null || nums.length < 4) {
9            return result;
10        }
11
12        // Sort the array to efficiently skip duplicates and use two pointers
13        Arrays.sort(nums);
14        int n = nums.length;
15
16        // First pointer
17        for (int i = 0; i < n - 3; i++) {
18            // Skip duplicate values for the first element
19            if (i > 0 && nums[i] == nums[i - 1]) {
20                continue;
21            }
22            
23            // Optimization: If the smallest possible sum is greater than target, no solution exists
24            if ((long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
25                break;
26            }
27            // Optimization: If the largest possible sum with this nums[i] is less than target, skip this index
28            if ((long) nums[i] + nums[n - 1] + nums[n - 2] + nums[n - 3] < target) {
29                continue;
30            }
31
32            // Second pointer
33            for (int j = i + 1; j < n - 2; j++) {
34                // Skip duplicate values for the second element
35                if (j > i + 1 && nums[j] == nums[j - 1]) {
36                    continue;
37                }
38                
39                // Optimization for the second element
40                if ((long) nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
41                    break;
42                }
43                if ((long) nums[i] + nums[j] + nums[n - 1] + nums[n - 2] < target) {
44                    continue;
45                }
46
47                // Two-pointer sweep for the remaining two elements
48                int left = j + 1;
49                int right = n - 1;
50
51                while (left < right) {
52                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
53
54                    if (sum == target) {
55                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
56
57                        // Skip duplicate values for the third element
58                        while (left < right && nums[left] == nums[left + 1]) {
59                            left++;
60                        }
61                        // Skip duplicate values for the fourth element
62                        while (left < right && nums[right] == nums[right - 1]) {
63                            right--;
64                        }
65
66                        left++;
67                        right--;
68                    } else if (sum < target) {
69                        left++; // Sum is too small, increase the lower bound
70                    } else {
71                        right--; // Sum is too large, decrease the upper bound
72                    }
73                }
74            }
75        }
76
77        return result;
78    }
79}