class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        Map<Integer,Integer> ans = new HashMap<>();

        int ar[] = new int[k];

        for(int i =0 ;i<n ;i++){
            if(!ans.containsKey(nums[i])){
            ans.put(nums[i],1);
            }
            else{
                ans.put(nums[i],ans.get(nums[i])+1);
            }
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(ans.entrySet());

list.sort((a, b) -> b.getValue() - a.getValue());
        int j =0;
        while(k-- >0){
            ar[j] = list.get(j).getKey();
            j++;
        }
        return ar;
    }
}