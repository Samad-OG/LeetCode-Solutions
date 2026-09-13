 import java.util.ArrayList;
import java.util.List;

class Solution {
    private static final String[] MAPPING = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits == null || digits.isEmpty()) return ans;
        backtrack(ans, digits, new StringBuilder(), 0);
        return ans;
    }

    private void backtrack(List<String> ans, String digits, StringBuilder sb, int index) {
        if (index == digits.length()) {
            ans.add(sb.toString());
            return;
        }
        
        String letters = MAPPING[digits.charAt(index) - '0'];
        for (char c : letters.toCharArray()) {
            sb.append(c);
            backtrack(ans, digits, sb, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
