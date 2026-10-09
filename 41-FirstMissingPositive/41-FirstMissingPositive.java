// Last updated: 09/10/2026, 09:24:09
class Solution {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }
        
        int n = nums.length;
        
        // Cycle sort: Place each number in its correct index if possible
        // e.g., the number 1 should go to index 0, 2 to index 1, etc.
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                // Swap nums[i] to its target index position (nums[i] - 1)
                int targetIndex = nums[i] - 1;
                int temp = nums[i];
                nums[i] = nums[targetIndex];
                nums[targetIndex] = temp;
            }
        }
        
        // Find the first index where the number does not match its expected index mapping
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        
        // If all positions are correctly matched, the missing number is n + 1
        return n + 1;
    }
}