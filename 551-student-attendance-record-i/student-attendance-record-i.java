class Solution {
    public boolean checkRecord(String s) {
        int absentCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') {
                absentCount++;
            }
        }
        return absentCount < 2 && !s.contains("LLL");
    }
}
