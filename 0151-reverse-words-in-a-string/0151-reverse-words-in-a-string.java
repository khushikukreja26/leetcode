class Solution {
    public String reverseWords(String s) {
        int n = s.length();
       StringBuilder sb = new StringBuilder(s);
       StringBuilder ans = new StringBuilder();

       sb.reverse();
       
       for(int i =0; i<n; i++){

        StringBuilder word = new StringBuilder();

        while(i<n && sb.charAt(i) != ' ' ) {
            word.append(sb.charAt(i));
            i++;
        }

        word.reverse();

        if (word.length() > 0){
            ans.append(" ").append(word);
        } 
       }
       return ans.substring(1);
    }
}