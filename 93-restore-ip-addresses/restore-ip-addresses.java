import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() < 4 || s.length() > 12) {
            return res;
        }
        backtrack(res, s, 0, "", 0);
        return res;
    }

    private void backtrack(List<String> res, String s, int index, String current, int count) {
        if (count == 4) {
            if (index == s.length()) {
                res.add(current.substring(0, current.length() - 1));
            }
            return;
        }
        for (int i = 1; i <= 3; i++) {
            if (index + i > s.length()) {
                break;
            }
            String part = s.substring(index, index + i);
            if ((part.startsWith("0") && part.length() > 1) || (i == 3 && Integer.parseInt(part) > 255)) {
                continue;
            }
            backtrack(res, s, index + i, current + part + ".", count + 1);
        }
    }
}
