class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] pref = new int[n];
        int[] suff = new int[n];
        int[] ans = new int[n];

        for(int i =1; i<n ; i++){
            pref[0] = 1;
            pref[i] = pref[i-1] * nums[i-1]; 
        }
        
        for(int i = n-2; i>=0; i--){
            suff[n-1] = 1;
            suff[i] = suff[i+1] * nums[i+1];
        }

        for(int i =0; i<n; i++){
            ans[i] = suff[i] * pref[i];
        }
        return ans;    
    }
}