// Last updated: 28/07/2026, 15:43:17
class NumArray {
    // prefixSums[i] will store the sum of elements from nums[0] to nums[i-1]
    private int[] prefixSums;

    public NumArray(int[] nums) {
        prefixSums = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefixSums[i + 1] = prefixSums[i] + nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
        // The sum from index 'left' to 'right' inclusive is 
        // the prefix sum up to 'right + 1' minus the prefix sum up to 'left'
        return prefixSums[right + 1] - prefixSums[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */