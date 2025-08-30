class Solution {
    public String largestOddNumber(String s) {
        int index=-1;
        int i;
        for(i=s.length()-1; i>=0; i--){
            if((s.charAt(i)-'0')%2==1){
                index =i;
                break;
            }
        }
        if(index==-1) return "";
        i=0;

        while(i<=index && s.charAt(i)=='0') i++;

        return s.substring(i, index+1);
    }
}