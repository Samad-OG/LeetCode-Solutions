import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        if (s == null) return result;

        int leftRem = 0;
        int rightRem = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                leftRem++;
            } else if (c == ')') {
                if (leftRem > 0) {
                    leftRem--;
                } else {
                    rightRem++;
                }
            }
        }

        Set<String> visited = new HashSet<>();
        backtrack(s, 0, leftRem, rightRem, 0, new StringBuilder(), visited, result);
        return result;
    }

    private void backtrack(String s, int index, int leftRem, int rightRem, int balance, StringBuilder current, Set<String> visited, List<String> result) {
        if (balance < 0) return;

        if (index == s.length()) {
            if (leftRem == 0 && rightRem == 0 && balance == 0) {
                String str = current.toString();
                if (!visited.contains(str)) {
                    visited.add(str);
                    result.add(str);
                }
            }
            return;
        }

        char c = s.charAt(index);
        int len = current.length();

        if (c == '(') {
            if (leftRem > 0) {
                backtrack(s, index + 1, leftRem - 1, rightRem, balance, current, visited, result);
            }
            current.append(c);
            backtrack(s, index + 1, leftRem, rightRem, balance + 1, current, visited, result);
            current.setLength(len);
        } else if (c == ')') {
            if (rightRem > 0) {
                backtrack(s, index + 1, leftRem, rightRem - 1, balance, current, visited, result);
            }
            current.append(c);
            backtrack(s, index + 1, leftRem, rightRem, balance - 1, current, visited, result);
            current.setLength(len);
        } else {
            current.append(c);
            backtrack(s, index + 1, leftRem, rightRem, balance, current, visited, result);
            current.setLength(len);
        }
    }
}
