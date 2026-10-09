// Last updated: 09/10/2026, 09:25:31
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // Sort the array to easily handle duplicates and use two pointers
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 2; i++) {
            // If the current minimum number is greater than 0, a sum of 0 is impossible
            if (nums[i] > 0) {
                break;
            }
            
            // Skip duplicate values for the first element
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            int left = i + 1;
            int right = nums.length - 1;
            
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    
                    // Skip duplicates for the second element
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    // Skip duplicates for the third element
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    
                    // Move both pointers inward after finding a valid triplet
                    left++;
                    right--;
                } else if (sum < 0) {
                    // Sum is too small, increase the lower bound
                    left++;
                } else {
                    // Sum is too large, decrease the upper bound
                    right--;
                }
            }
        }
        
        return result;
    }
}