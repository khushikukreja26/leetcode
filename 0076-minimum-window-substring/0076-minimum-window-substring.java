class Solution {
    public String minWindow(String s, String t) {
        int[] freq = new int[128];
        for (char ch : t.toCharArray()) freq[(int)ch]++;
        int count = t.length(), res = Integer.MAX_VALUE, left = 0, right = 0, index = 0;

        while (right < s.length()) {
            if(freq[(int) s.charAt(right)] > 0) {
                count--;
            }
            freq[(int) s.charAt(right)]--;
            right++;
            while (count == 0) {
                if (right - left < res) {
                    res = right - left;
                    index = left;
                }
                // X Y N P 'A'
                // Left index at 'X' till 'A'
                if(freq[(int) s.charAt(left) ] == 0) count++;
                freq[(int) s.charAt(left)]++;
                left++;
            }
        }
        return res == Integer.MAX_VALUE ? "" : s.substring(index, index + res);
    }
}