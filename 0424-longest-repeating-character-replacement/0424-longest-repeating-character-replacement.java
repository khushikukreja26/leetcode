class Solution {
    public int characterReplacement(String s, int k) {
     //brute force
    //  int n = s.length(); 
    //  int maxLength = 0;
    //  for(int i = 0; i<n; i++){
    //     int maxFreq = 0;
    //     int[] hash = new int[26];
    //     Arrays.fill(hash, 0);
    //     for(int j = i; j<n; j++){
    //         hash[s.charAt(j)-'A']++;
    //         maxFreq = Math.max(maxFreq, hash[s.charAt(j)-'A']);
    //         int changes = (j-i+1) - maxFreq;
    //         if(changes<=k){
    //             maxLength = Math.max(maxLength, j-i+1);
    //         }
    //         else{
    //             break;
    //         }
    //     }
    //  }   
    //  return maxLength;

    //optimal 
    int n = s.length();
    int l = 0, r = 0;
    int maxLength = 0, maxFreq = 0;
    int[] hash = new int[26];
    while(r<n){
        hash[s.charAt(r)-'A']++;
        maxFreq = Math.max(maxFreq, hash[s.charAt(r)-'A']);
        if((r-l+1)-maxFreq > k){
            hash[s.charAt(l)-'A']--;
            l++;
        }
        if((r-l+1)-maxFreq <= k){
            maxLength = Math.max(maxLength, r-l+1);
        } 
        r++;
    }
    return maxLength;
    }
}