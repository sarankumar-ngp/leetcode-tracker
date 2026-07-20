// Last updated: 20/07/2026, 15:22:33
1import java.util.ArrayList;
2import java.util.List;
3
4class Solution {
5    public List<String> summaryRanges(int[] nums) {
6        List<String> result = new ArrayList<>();
7        if (nums == null || nums.length == 0) {
8            return result;
9        }
10
11        int n = nums.length;
12        for (int i = 0; i < n; i++) {
13            int start = nums[i];
14            
15            // Keep moving forward as long as numbers are consecutive
16            while (i + 1 < n && nums[i + 1] == nums[i] + 1) {
17                i++;
18            }
19            
20            // If start and current elements are the same, format as "a", else "a->b"
21            if (start == nums[i]) {
22                result.add(String.valueOf(start));
23            } else {
24                result.add(start + "->" + nums[i]);
25            }
26        }
27
28        return result;
29    }
30}