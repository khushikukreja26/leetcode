// extra time is taken to store in set ...... thats why TLE
/*
class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    Set<List<Integer>> set = new HashSet<>();

    void solve(int[] ip, List<Integer> op, int target, int sum, int idx) {

        // base case
        if (sum == target) {
            // no need to sort op bcz op is automatically sorted as we have sort the array in start 
            set.add(new ArrayList<>(op)); // deep copy
            return;
        }

        if (sum > target || idx >= ip.length) {
            return;
        }

        // take current element
        op.add(ip[idx]);
        solve(ip, op, target, sum + ip[idx], idx + 1);

        // backtrack
        op.remove(op.size() - 1);

        // skip current element
        solve(ip, op, target, sum, idx + 1);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates); // same as sort(ip.begin(), ip.end())

        solve(candidates, new ArrayList<>(), target, 0, 0);

        ans.addAll(set);
        return ans;
    }
}
*/

// solve without using set ..... dandling duplicates wisely(bcz for this purpose set was needed)
/*
class Solution {

    List<List<Integer>> ans = new ArrayList<>();

    void solve(int[] nums, int target, List<Integer> temp, int idx) {

        if (target == 0) {
            ans.add(new ArrayList<>(temp)); // deep copy
            return;
        }

        if (target < 0 || idx >= nums.length) return;

        // ✅ Option 1: Pick current element
        temp.add(nums[idx]);
        solve(nums, target - nums[idx], temp, idx + 1);
        temp.remove(temp.size() - 1);

        // ✅ Option 2: Skip current element and all its duplicates
        int next = idx + 1;
        while (next < nums.length && nums[next] == nums[idx]) {
            next++;
        }

        solve(nums, target, temp, next);
    }

    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        Arrays.sort(nums);
        solve(nums, target, new ArrayList<>(), 0);
        return ans;
    }
}
*/
//~~~~~~~~~~ Back-Tracking Wayy ~~~~~~~~~~~
//~for back-tracking think~ -> What are the valid next candidates I can take?
class Solution {

    List<List<Integer>> ans = new ArrayList<>();

    void solve(int[] nums, List<Integer> temp, int target, int start) {
        if (target == 0) {
            ans.add(new ArrayList<>(temp)); // deep copy
            return;
        }

        for (int i = start; i < nums.length; i++) {

            // skip duplicates at the same recursion level
            if (i > start && nums[i] == nums[i - 1]) continue;

            // prune
            if (nums[i] > target) break;

            temp.add(nums[i]);
            solve(nums, temp, target - nums[i], i + 1);
            temp.remove(temp.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        Arrays.sort(nums);
        solve(nums, new ArrayList<>(), target, 0);
        return ans;
    }
}

