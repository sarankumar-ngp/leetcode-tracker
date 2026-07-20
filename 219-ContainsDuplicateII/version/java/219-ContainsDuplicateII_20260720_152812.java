// Last updated: 20/07/2026, 15:28:12
1import java.util.HashMap;
2
3class Solution {
4    public boolean containsNearbyDuplicate(int[] nums, int k) {
5        // Maps the number to its most recent index
6        HashMap<Integer, Integer> map = new HashMap<>();
7
8        for (int i = 0; i < nums.length; i++) {
9            // If the map contains the number, check the distance constraint
10            if (map.containsKey(nums[i])) {
11                int previousIndex = map.get(nums[i]);
12                if (i - previousIndex <= k) {
13                    return true;
14                }
15            }
16            // Always update the map with the latest index
17            map.put(nums[i], i);
18        }
19
20        return false;
21    }
22}