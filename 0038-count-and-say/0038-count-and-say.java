class Solution {
    public String countAndSay(int n) {
        // 1 ke liye toh 1
        if(n==1) return "1";

        //recursion 
        String say = countAndSay(n-1);

        //Processing
        StringBuilder ans = new StringBuilder();

        //loop saare character ke liye
        for(int i =0; i<say.length(); i++){
            //ek occurence ko count krne ke liye
            char ch = say.charAt(i);
            int count = 1;

            //saari occurences ko count krne ke liye
            while(i<say.length()-1 && say.charAt(i)==say.charAt(i+1)){
                count++;
                i++;
            }
            //final ans mein add krne ke liye
        ans = ans.append(count).append(ch);
        }
        
        return ans.toString();
    }
}