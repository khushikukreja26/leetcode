class Solution {
    public void moveZeroes(int[] nums) {
        int j =0; 
        while(j<nums.length && nums[j] != 0){
            j++;
        }
        for(int i = j+1; i<nums.length; i++){
            if(nums[i]!=0){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
    }
}