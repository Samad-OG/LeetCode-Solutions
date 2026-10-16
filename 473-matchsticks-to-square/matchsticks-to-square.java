import java.util.Arrays;

class Solution {
    public boolean makesquare(int[] matchsticks) {
        if (matchsticks == null || matchsticks.length < 4) {
            return false;
        }
        
        int sum = 0;
        for (int stick : matchsticks) {
            sum += stick;
        }
        
        if (sum % 4 != 0) {
            return false;
        }
        
        int target = sum / 4;
        Arrays.sort(matchsticks);
        
        int[] sides = new int[4];
        return dfs(matchsticks, matchsticks.length - 1, sides, target);
    }
    
    private boolean dfs(int[] matchsticks, int index, int[] sides, int target) {
        if (index < 0) {
            return sides[0] == target && sides[1] == target && sides[2] == target;
        }
        
        int stick = matchsticks[index];
        for (int i = 0; i < 4; i++) {
            if (sides[i] + stick <= target) {
                sides[i] += stick;
                if (dfs(matchsticks, index - 1, sides, target)) {
                    return true;
                }
                sides[i] -= stick;
            }
            
            if (sides[i] == 0) {
                break;
            }
        }
        
        return false;
    }
}
