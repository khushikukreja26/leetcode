class Solution {
    public boolean containsDuplicate(int[] nums) {
        // Arrays.sort(nums);
        // for(int i = 1; i<nums.length; i++){
        //     if(nums[i-1]==nums[i]){
        //         return true;
        //     }
        // }
        // return false;

        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }
        
        return set.size() < nums.length;
    }
}