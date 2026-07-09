// Last updated: 09/07/2026, 10:13:43
class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0;
        int total = 0;
        int c = nums.length;
        total = c * ( c + 1) / 2;

        for (int i = 0; i < c; i++) {
            sum += nums[i];
        }

        return total - sum;
    }
}