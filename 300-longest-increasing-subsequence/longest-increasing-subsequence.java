class Solution {
    private int occurrenceBS(List<Integer> ends, int target) {
        int left = 0;
        int right = ends.size() - 1;

        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (ends.get(mid) >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        // post processing
        if (ends.get(left) >= target) return left;
        else if (ends.get(right) >= target) return right;
        else return -1;
    }
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        List<Integer> ends = new ArrayList<>();
        ends.add(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            // case 1: append
            if (nums[i] > ends.get(ends.size() - 1)) {
                ends.add(nums[i]);
            }

            // case 2: replace
            else {
                int lenLISToReplace = occurrenceBS(ends, nums[i]);
                ends.set(lenLISToReplace, nums[i]);
            }
        }

        return ends.size();
    }
}