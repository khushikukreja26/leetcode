class Solution {
    public int search(int[] nums, int target) {
        int low = 0 , high = nums.length - 1;
        while (low<=high){
            int mid = (low+high)/2;

            if(nums[mid]==target){
                return mid;
            }

            //if left is sorted
            if(nums[low]<=nums[mid]){
                //search in left 
                if(nums[low]<=target && target<nums[mid]){
                    high = mid - 1;
                }
                //search in right 
                else{
                    low = mid + 1;
                }
            }

            //right is sorted
            else{
                //search in right 
                if(nums[mid]<target && target <= nums[high]){
                    low = mid + 1;
                }
                //search in left 
                else{
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}