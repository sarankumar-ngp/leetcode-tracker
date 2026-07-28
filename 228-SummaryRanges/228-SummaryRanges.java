// Last updated: 28/07/2026, 15:43:34
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int start = nums[i];
            
            // Keep moving forward as long as numbers are consecutive
            while (i + 1 < n && nums[i + 1] == nums[i] + 1) {
                i++;
            }
            
            // If start and current elements are the same, format as "a", else "a->b"
            if (start == nums[i]) {
                result.add(String.valueOf(start));
            } else {
                result.add(start + "->" + nums[i]);
            }
        }

        return result;
    }
}