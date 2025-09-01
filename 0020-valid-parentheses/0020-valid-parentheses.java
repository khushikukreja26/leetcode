import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        
        for (char ch : s.toCharArray()) {
            // Opening brackets push karo
            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            } 
            else {
                // Closing bracket mila to stack empty nahi hona chahiye
                if (st.isEmpty()) return false;
                
                char top = st.pop();
                // Check correct matching
                if ((ch == ')' && top != '(') ||
                    (ch == '}' && top != '{') ||
                    (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }
        // Agar sab balance ho gaye to stack empty hona chahiye
        return st.isEmpty();
    }
}
