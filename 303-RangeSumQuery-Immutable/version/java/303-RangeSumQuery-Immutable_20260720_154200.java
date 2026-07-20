// Last updated: 20/07/2026, 15:42:00
1class NumArray {
2    // prefixSums[i] will store the sum of elements from nums[0] to nums[i-1]
3    private int[] prefixSums;
4
5    public NumArray(int[] nums) {
6        prefixSums = new int[nums.length + 1];
7        for (int i = 0; i < nums.length; i++) {
8            prefixSums[i + 1] = prefixSums[i] + nums[i];
9        }
10    }
11    
12    public int sumRange(int left, int right) {
13        // The sum from index 'left' to 'right' inclusive is 
14        // the prefix sum up to 'right + 1' minus the prefix sum up to 'left'
15        return prefixSums[right + 1] - prefixSums[left];
16    }
17}
18
19/**
20 * Your NumArray object will be instantiated and called as such:
21 * NumArray obj = new NumArray(nums);
22 * int param_1 = obj.sumRange(left,right);
23 */