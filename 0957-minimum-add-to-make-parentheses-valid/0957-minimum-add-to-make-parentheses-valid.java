class Solution {
    public int minAddToMakeValid(String s) {
        int open = 0;      // unmatched '(' count
        int add = 0;       // how many ')' we need to add

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                open++; // ek open bracket mila
            } else { // ch == ')'
                if (open > 0) {
                    open--; // ek '(' ke saath pair ho gaya
                } else {
                    add++;  // koi '(' nahi tha, to ye ')' extra hai
                }
            }
        }

        // jo open brackets bache hain, unke liye closing chahiye
        return add + open;
    }
}
