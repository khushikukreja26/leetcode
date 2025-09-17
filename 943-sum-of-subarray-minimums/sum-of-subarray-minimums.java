class Solution {
    public int[] getNSL(int[] arr, int n){
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i =0; i<n ; i++){
            while(!st.empty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            result[i] = st.empty() ? -1 : st.peek();
            st.push(i);
        }
        return result;
    }
    public int[] getNSR(int[] arr, int n){
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = (n-1); i>=0 ; i--){
            while(!st.empty() && arr[st.peek()]>arr[i]){
                st.pop();
            }
            result[i] = st.empty() ? n : st.peek();
            st.push(i);
        }
        return result;
    }
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;

        int[] NSL = getNSL(arr, n);
        int[] NSR = getNSR(arr, n);

        long sum = 0;
        int M = 1000000007;

        for(int i=0; i<n; i++){
            long ls = i - NSL[i];
            long rs = NSR[i] - i;
            long totalWays = ls * rs;
            long totalSum = arr[i]*totalWays;
            sum = (sum + totalSum) % M;
        }
        return (int)sum;
    }
}