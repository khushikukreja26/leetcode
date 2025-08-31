class Solution {
    public int minValue(int[] freq){
        int min_value = Integer.MAX_VALUE;
        for(int i =0; i<26; i++){
           if(freq[i]!=0) min_value = Math.min(min_value, freq[i]);
        }
        return min_value;
    }
    public int maxValue(int[] freq){
        int max_value =0;
        for(int i =0; i<26; i++){
            max_value = Math.max(max_value, freq[i]);
        }
        return max_value;
    }
    public int beautySum(String s) {
        int n = s.length();
        int sum =0;
        //to find substrings we will take nested loops 
        for(int i=0; i<n; i++){
            //to find frequency
            int[] freq = new int[26];
            for(int j=i; j<n; j++){
                freq[s.charAt(j)-'a']++;
                //to find beauty
                int beauty = maxValue(freq) - minValue(freq);
                sum = sum + beauty;
            }
        }
        return sum;
    }
}