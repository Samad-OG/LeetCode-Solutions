import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        if (num == null || num.length() == 0) {
            return result;
        }
        backtrack(result, new StringBuilder(), num, target, 0, 0, 0);
        return result;
    }

    private void backtrack(List<String> result, StringBuilder sb, String num, int target, int index, long eval, long prevRes) {
        if (index == num.length()) {
            if (eval == target) {
                result.add(sb.toString());
            }
            return;
        }

        for (int i = index; i < num.length(); i++) {
            if (i != index && num.charAt(index) == '0') {
                break;
            }

            long curr = Long.parseLong(num.substring(index, i + 1));
            int len = sb.length();

            if (index == 0) {
                sb.append(curr);
                backtrack(result, sb, num, target, i + 1, curr, curr);
                sb.setLength(len);
            } else {
                sb.append("+").append(curr);
                backtrack(result, sb, num, target, i + 1, eval + curr, curr);
                sb.setLength(len);

                sb.append("-").append(curr);
                backtrack(result, sb, num, target, i + 1, eval - curr, -curr);
                sb.setLength(len);

                sb.append("*").append(curr);
                backtrack(result, sb, num, target, i + 1, eval - prevRes + prevRes * curr, prevRes * curr);
                sb.setLength(len);
            }
        }
    }
}
