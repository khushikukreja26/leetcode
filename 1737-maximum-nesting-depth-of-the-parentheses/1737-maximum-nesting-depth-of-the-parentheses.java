class Solution {
    public int maxDepth(String s) {
        int openBracket=0;
        int result=0;

        for(char ch: s.toCharArray()){
            if(ch=='('){
                openBracket++;
                result = Math.max(openBracket,result);
            }
            if(ch==')'){
                openBracket--;
            }
        }
        
        return result;
    }
}