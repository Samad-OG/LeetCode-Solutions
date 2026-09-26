import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        return backtrack(s, new HashSet<>(wordDict), new HashMap<>());
    }

    private List<String> backtrack(String s, Set<String> wordSet, Map<String, List<String>> memo) {
        if (memo.containsKey(s)) {
            return memo.get(s);
        }
        
        List<String> res = new ArrayList<>();
        if (s.isEmpty()) {
            res.add("");
            return res;
        }
        
        for (int i = 1; i <= s.length(); i++) {
            String word = s.substring(0, i);
            if (wordSet.contains(word)) {
                List<String> subList = backtrack(s.substring(i), wordSet, memo);
                for (String sub : subList) {
                    res.add(word + (sub.isEmpty() ? "" : " ") + sub);
                }
            }
        }
        
        memo.put(s, res);
        return res;
    }
}
