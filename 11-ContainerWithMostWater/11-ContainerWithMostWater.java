// Last updated: 09/10/2026, 09:25:46
class Solution {
    public int maxArea(int[] height) {
        int maxWater = 0;
        int left = 0;
        int right = height.length - 1;
        
        while (left < right) {
            // Calculate the current width
            int width = right - left;
            
            // Calculate the area using the shorter line
            int currentWater = Math.min(height[left], height[right]) * width;
            
            // Update the maximum water found so far
            maxWater = Math.max(maxWater, currentWater);
            
            // Move the pointer pointing to the shorter line inward
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        
        return maxWater;
    }
}