class Solution {
    public int findMinMoves(int[] machines) {
        int total = 0;
        for (int m : machines) {
            total += m;
        }
        
        if (total % machines.length != 0) {
            return -1;
        }
        
        int target = total / machines.length;
        int maxMoves = 0;
        int balance = 0;
        
        for (int m : machines) {
            balance += m - target;
            maxMoves = Math.max(maxMoves, Math.max(Math.abs(balance), m - target));
        }
        
        return maxMoves;
    }
}
