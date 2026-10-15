import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal <= 0) {
            return true;
        }
        
        int sum = maxChoosableInteger * (maxChoosableInteger + 1) / 2;
        if (sum < desiredTotal) {
            return false;
        }
        
        return canWin(desiredTotal, 0, maxChoosableInteger, new HashMap<>());
    }
    
    private boolean canWin(int total, int state, int maxChoosable, Map<Integer, Boolean> memo) {
        if (total <= 0) {
            return false;
        }
        
        if (memo.containsKey(state)) {
            return memo.get(state);
        }
        
        for (int i = 1; i <= maxChoosable; i++) {
            int bit = 1 << (i - 1);
            if ((state & bit) == 0) {
                if (i >= total || !canWin(total - i, state | bit, maxChoosable, memo)) {
                    memo.put(state, true);
                    return true;
                }
            }
        }
        
        memo.put(state, false);
        return false;
    }
}
