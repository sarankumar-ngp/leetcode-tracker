// Last updated: 20/07/2026, 15:54:51
1import java.util.ArrayList;
2import java.util.Arrays;
3import java.util.List;
4
5class Solution {
6    public List<List<Integer>> threeSum(int[] nums) {
7        List<List<Integer>> result = new ArrayList<>();
8        // Sort the array to easily handle duplicates and use two pointers
9        Arrays.sort(nums);
10        
11        for (int i = 0; i < nums.length - 2; i++) {
12            // If the current minimum number is greater than 0, a sum of 0 is impossible
13            if (nums[i] > 0) {
14                break;
15            }
16            
17            // Skip duplicate values for the first element
18            if (i > 0 && nums[i] == nums[i - 1]) {
19                continue;
20            }
21            
22            int left = i + 1;
23            int right = nums.length - 1;
24            
25            while (left < right) {
26                int sum = nums[i] + nums[left] + nums[right];
27                
28                if (sum == 0) {
29                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
30                    
31                    // Skip duplicates for the second element
32                    while (left < right && nums[left] == nums[left + 1]) {
33                        left++;
34                    }
35                    // Skip duplicates for the third element
36                    while (left < right && nums[right] == nums[right - 1]) {
37                        right--;
38                    }
39                    
40                    // Move both pointers inward after finding a valid triplet
41                    left++;
42                    right--;
43                } else if (sum < 0) {
44                    // Sum is too small, increase the lower bound
45                    left++;
46                } else {
47                    // Sum is too large, decrease the upper bound
48                    right--;
49                }
50            }
51        }
52        
53        return result;
54    }
55}