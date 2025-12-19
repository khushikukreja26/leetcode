class Solution {
    public int maxArea(int[] height) {
        //bruteforce
        // int ans = 0; 
        // for(int i=0; i<height.length; i++){
        //     for(int j=i+1; j<height.length; j++){
        //         int wd = j-i;
        //         int ht = Math.min(height[i], height[j]);
        //         int area = wd * ht;
        //         ans = Math.max(ans, area);
        //     }
        // }
        // return ans;

        //optimal approach
        int ans = 0;
        int l = 0 , r = height.length-1;
        while(l<r){
            int wd = r - l;
            int ht = Math.min(height[l], height[r]);
            int area = wd * ht;
            ans = Math.max(ans, area);
           if(height[l]<height[r]){
                l++;
           } 
           else{
            r--;
           }
        }
        return ans;
    }
}