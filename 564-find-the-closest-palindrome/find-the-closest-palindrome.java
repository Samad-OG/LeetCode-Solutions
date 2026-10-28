import java.util.ArrayList;
import java.util.List;

class Solution {
    public String nearestPalindromic(String n) {
        long num = Long.parseLong(n);
        int len = n.length();
        
        if (num <= 10) return String.valueOf(num - 1);
        if (num == 11) return "9";
        
        List<Long> candidates = new ArrayList<>();
        candidates.add((long) Math.pow(10, len - 1) - 1);
        candidates.add((long) Math.pow(10, len) + 1);
        
        long prefix = Long.parseLong(n.substring(0, (len + 1) / 2));
        
        for (long i = -1; i <= 1; i++) {
            String pStr = String.valueOf(prefix + i);
            StringBuilder sb = new StringBuilder(pStr);
            if (len % 2 == 1) {
                sb.append(new StringBuilder(pStr.substring(0, pStr.length() - 1)).reverse());
            } else {
                sb.append(new StringBuilder(pStr).reverse());
            }
            candidates.add(Long.parseLong(sb.toString()));
        }
        
        long minDiff = Long.MAX_VALUE;
        long result = 0;
        
        for (long cand : candidates) {
            if (cand == num) continue;
            long diff = Math.abs(cand - num);
            if (diff < minDiff) {
                minDiff = diff;
                result = cand;
            } else if (diff == minDiff) {
                result = Math.min(result, cand);
            }
        }
        
        return String.valueOf(result);
    }
}
