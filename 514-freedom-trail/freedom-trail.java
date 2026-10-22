import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int findRotateSteps(String ring, String key) {
        int rLen = ring.length();
        int kLen = key.length();
        
        Map<Character, List<Integer>> positions = new HashMap<>();
        for (int i = 0; i < rLen; i++) {
            positions.computeIfAbsent(ring.charAt(i), x -> new ArrayList<>()).add(i);
        }
        
        int[][] dp = new int[kLen + 1][rLen];
        
        for (int i = kLen - 1; i >= 0; i--) {
            char c = key.charAt(i);
            for (int rIdx = 0; rIdx < rLen; rIdx++) {
                int minSteps = Integer.MAX_VALUE;
                for (int nextIdx : positions.get(c)) {
                    int dist = Math.abs(rIdx - nextIdx);
                    int steps = Math.min(dist, rLen - dist) + 1 + dp[i + 1][nextIdx];
                    minSteps = Math.min(minSteps, steps);
                }
                dp[i][rIdx] = minSteps;
            }
        }
        
        return dp[0][0];
    }
}
