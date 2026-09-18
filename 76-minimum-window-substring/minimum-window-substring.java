class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        int[] map = new int[128];
        for (char c : t.toCharArray()) {
            map[c]++;
        }

        int count = t.length();
        int left = 0;
        int right = 0;
        int minLen = Integer.MAX_VALUE;
        int startIndex = 0;

        while (right < s.length()) {
            char cRight = s.charAt(right);
            if (map[cRight] > 0) {
                count--;
            }
            map[cRight]--;
            right++;

            while (count == 0) {
                if (right - left < minLen) {
                    minLen = right - left;
                    startIndex = left;
                }

                char cLeft = s.charAt(left);
                map[cLeft]++;
                if (map[cLeft] > 0) {
                    count++;
                }
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(startIndex, startIndex + minLen);
    }
}
