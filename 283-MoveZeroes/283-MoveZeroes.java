// Last updated: 09/07/2026, 10:13:42
class Solution {
    public void moveZeroes(int[] nums) {
        int j = 0 ;
        int temp = 0 ;
        for(int i = 0 ; i<nums.length ; i++){
            if(nums[i]!=0){
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
        
    }
}