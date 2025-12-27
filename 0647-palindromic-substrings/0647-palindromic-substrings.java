class Solution {
    public int countSubstrings(String s) {
        int cnt = 0;
        int n = s.length();
        for (int i = 0;i < n;i++){
            int l = i;
            int r = i;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)){
                cnt ++;
                l --;
                r ++;
            }

            int left = i;
            int right = i+1;
            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)){
                left --;
                right++;
                cnt ++;
            }
        }
        return cnt;
    }
}