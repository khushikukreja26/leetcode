class Solution {
    int m, n;
    int[][] memo;
    private int solve(String s1, String s2, int i, int j){
        if(i>=m || j>=n) return 0;
        if(memo[i][j] != -1){
            return memo[i][j];
        }
        if(s1.charAt(i) == s2.charAt(j)){
            return memo[i][j] = 1 + solve(s1, s2, i+1, j+1);
        }
        return memo[i][j] = Math.max(solve(s1,s2,i+1,j),solve(s1,s2,i,j+1));
    }
    public int longestCommonSubsequence(String s1, String s2) {
        m = s1.length();
        n = s2.length();
        memo = new int[m][n];
        for(int[] row: memo) Arrays.fill(row, -1);
        return solve(s1, s2, 0, 0);
        
    }
}