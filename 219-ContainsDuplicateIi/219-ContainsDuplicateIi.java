// Last updated: 28/07/2026, 15:43:41
import java.util.HashMap;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // Maps the number to its most recent index
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            // If the map contains the number, check the distance constraint
            if (map.containsKey(nums[i])) {
                int previousIndex = map.get(nums[i]);
                if (i - previousIndex <= k) {
                    return true;
                }
            }
            // Always update the map with the latest index
            map.put(nums[i], i);
        }

        return false;
    }
}