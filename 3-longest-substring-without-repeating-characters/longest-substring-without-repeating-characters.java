 class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        int start = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            for (int j = start; j < i; j++) {
                if (s.charAt(j) == ch) {
                    start = j + 1;
                    break;
                }
            }
            
            int currentLen = i - start + 1;
            if (currentLen > maxLen) {
                maxLen = currentLen;
            }
        }
        
        return maxLen;
    }
}