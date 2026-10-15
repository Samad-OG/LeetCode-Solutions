class Solution {
    public boolean repeatedSubstringPattern(String s) {
        String doubled = s + s;
        String modified = doubled.substring(1, doubled.length() - 1);
        return modified.contains(s);
    }
}
