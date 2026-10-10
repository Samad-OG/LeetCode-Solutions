import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public boolean canCross(int[] stones) {
        if (stones == null || stones.length == 0) {
            return false;
        }
        
        int n = stones.length;
        if (n > 1 && stones[1] != 1) {
            return false;
        }
        
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(stones[i], new HashSet<>());
        }
        
        map.get(0).add(0);
        
        for (int i = 0; i < n; i++) {
            int stone = stones[i];
            for (int k : map.get(stone)) {
                for (int step = k - 1; step <= k + 1; step++) {
                    if (step > 0 && map.containsKey(stone + step)) {
                        map.get(stone + step).add(step);
                    }
                }
            }
        }
        
        return !map.get(stones[n - 1]).isEmpty();
    }
}
