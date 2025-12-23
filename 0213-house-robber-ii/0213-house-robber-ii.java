class Solution {
    public int solve(List<Integer> arr){
        int n = arr.size();
        if (n == 1) return arr.get(0);
        int prev = arr.get(0);
        int prev2 = 0;
        for(int i = 1; i<n ; i++){
            int pick = arr.get(i);
            if (i > 1) pick += prev2;
            // Skip the current house
            int nonPick = prev;

            // Choose maximum
            int cur_i = Math.max(pick, nonPick);

            // Update prev2 and prev
            prev2 = prev;
            prev = cur_i;
        }
        return prev;
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];

        // arr1 excludes first house
        List<Integer> arr1 = new ArrayList<>();
        // arr2 excludes last house
        List<Integer> arr2 = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            if (i != 0) arr1.add(nums[i]);
            if (i != n - 1) arr2.add(nums[i]);
        }

        // Return maximum of both cases
        return Math.max(solve(arr1), solve(arr2));
    }
}