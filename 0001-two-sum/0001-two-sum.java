class Solution {
    public int[] twoSum(int[] nums, int target) {
        //Brute Force 
        // for(int i = 0; i<nums.length; i++){
        //     for(int j = i+1; j<nums.length; j++){
        //         int sum = nums[i]+nums[j];
        //         if(sum == target){
        //             int[] result = {i,j};
        //             return result;
        //         }
        //     }
        // }
        // return new int[]{-1, -1};

        //Better Solution 
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<nums.length; i++){
            int numNeeded = target - nums[i];
            if(map.containsKey(numNeeded)){
                return new int[] {map.get(numNeeded), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1,-1};
    }
}