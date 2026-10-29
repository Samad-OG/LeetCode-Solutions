import java.util.*;

class Solution {
    public boolean isValid(String code) {
        Stack<String> stack = new Stack<>();
        int i = 0;
        while (i < code.length()) {
            if (i > 0 && stack.isEmpty()) return false;
            
            if (code.startsWith("<![CDATA[", i)) {
                int j = code.indexOf("]]>", i + 9);
                if (j == -1) return false;
                i = j + 3;
            } else if (code.startsWith("</", i)) {
                int j = code.indexOf(">", i + 2);
                if (j == -1) return false;
                String tag = code.substring(i + 2, j);
                if (stack.isEmpty() || !stack.pop().equals(tag)) return false;
                i = j + 1;
            } else if (code.startsWith("<", i)) {
                int j = code.indexOf(">", i + 1);
                if (j == -1) return false;
                String tag = code.substring(i + 1, j);
                if (tag.length() < 1 || tag.length() > 9) return false;
                for (int k = 0; k < tag.length(); k++) {
                    if (!Character.isUpperCase(tag.charAt(k))) return false;
                }
                stack.push(tag);
                i = j + 1;
            } else {
                i++;
            }
        }
        return stack.isEmpty();
    }
}
