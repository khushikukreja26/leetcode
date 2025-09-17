class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();
        int n = num.length();

        for(int i = 0; i < n; i++){
            while(!st.empty() && k > 0 && (st.peek() - '0') > (num.charAt(i) - '0')){
                st.pop();
                k--;
            }
            st.push(num.charAt(i));
        }

        while(k > 0){
            st.pop();
            k--;
        }

        // build result
        StringBuilder sb = new StringBuilder();
        for(char c : st){
            sb.append(c);
        }

        // remove leading zeros
        while(sb.length() > 0 && sb.charAt(0) == '0'){
            sb.deleteCharAt(0);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}