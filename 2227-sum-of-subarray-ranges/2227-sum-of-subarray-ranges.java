class Solution {
    public int[] getNSL(int[] arr, int n){
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < n; i++){
            while(!st.empty() && arr[st.peek()] >= arr[i]){
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
        for(int i = n - 1; i >= 0; i--){
            while(!st.empty() && arr[st.peek()] > arr[i]){
                st.pop();
            }
            result[i] = st.empty() ? n : st.peek();
            st.push(i);
        }
        return result;
    }

    public long sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] NSL = getNSL(arr, n);
        int[] NSR = getNSR(arr, n);

        long sum = 0;
        for(int i = 0; i < n; i++){
            long ls = i - NSL[i];
            long rs = NSR[i] - i;
            sum += (long) arr[i] * ls * rs;
        }
        return sum;
    }

    public int[] getNGL(int[] arr, int n){
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < n; i++){
            while(!st.empty() && arr[st.peek()] <= arr[i]){
                st.pop();
            }
            result[i] = st.empty() ? -1 : st.peek();
            st.push(i);
        }
        return result;
    }

    public int[] getNGR(int[] arr, int n){
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = n - 1; i >= 0; i--){
            while(!st.empty() && arr[st.peek()] < arr[i]){
                st.pop();
            }
            result[i] = st.empty() ? n : st.peek();
            st.push(i);
        }
        return result;
    }

    public long sumSubarrayMaxs(int[] arr) {
        int n = arr.length;
        int[] NGL = getNGL(arr, n);
        int[] NGR = getNGR(arr, n);

        long sum = 0;
        for(int i = 0; i < n; i++){
            long lg = i - NGL[i];
            long rg = NGR[i] - i;
            sum += (long) arr[i] * lg * rg;
        }
        return sum;
    }

    public long subArrayRanges(int[] nums) {
        return sumSubarrayMaxs(nums) - sumSubarrayMins(nums);
    }
}