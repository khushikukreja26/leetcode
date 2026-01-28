class Solution {
    public int divide(int dividend, int divisor) {
        
        long n=dividend/divisor;
        // if(n<Integer.MIN_VALUE) return 
        if(dividend<=-2147483648 && divisor==1) return -2147483648;
        if(dividend<=-2147483648 && divisor==-1) return 2147483647;
        return (int) n;
    }
}