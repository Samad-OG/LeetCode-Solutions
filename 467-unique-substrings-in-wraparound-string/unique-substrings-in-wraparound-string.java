class Solution {
    public int findSubstringInWraproundString(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int[] count = new int[26];
        int maxLengthCur = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (i > 0 && (s.charAt(i) - s.charAt(i - 1) == 1 || s.charAt(i - 1) - s.charAt(i) == 25)) {
                maxLengthCur++;
            } else {
                maxLengthCur = 1;
            }
            
            int index = s.charAt(i) - 'a';
            count[index] = Math.max(count[index], maxLengthCur);
        }
        
        int sum = 0;
        for (int i = 0; i < 26; i++) {
            sum += count[i];
        }
        
        return sum;
    }
}
