// Last updated: 20/07/2026, 15:53:14
1class Solution {
2    public int maxArea(int[] height) {
3        int maxWater = 0;
4        int left = 0;
5        int right = height.length - 1;
6        
7        while (left < right) {
8            // Calculate the current width
9            int width = right - left;
10            
11            // Calculate the area using the shorter line
12            int currentWater = Math.min(height[left], height[right]) * width;
13            
14            // Update the maximum water found so far
15            maxWater = Math.max(maxWater, currentWater);
16            
17            // Move the pointer pointing to the shorter line inward
18            if (height[left] < height[right]) {
19                left++;
20            } else {
21                right--;
22            }
23        }
24        
25        return maxWater;
26    }
27}