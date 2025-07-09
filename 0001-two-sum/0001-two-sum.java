class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        result[0]=result[1]=-1;
        HashMap<Integer, Integer> mpp = new HashMap<>();
        for(int i =0; i<nums.length; i++){
            int num = nums[i];
            int numNeeded = target - num;
            if(mpp.containsKey(numNeeded)){
                result[0]=mpp.get(numNeeded);
                result[1]=i;
                return result;
            }
            mpp.put(nums[i],i); 
        }   
        return result;
    }
}