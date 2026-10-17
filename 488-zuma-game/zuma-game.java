import java.util.*;

class Solution {
    public int findMinStep(String board, String hand) {
        char[] handChars = hand.toCharArray();
        Arrays.sort(handChars);
        Map<String, Integer> memo = new HashMap<>();
        int res = dfs(board, new String(handChars), memo);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private int dfs(String board, String hand, Map<String, Integer> memo) {
        if (board.isEmpty()) return 0;
        if (hand.isEmpty()) return Integer.MAX_VALUE;
        
        String key = board + "#" + hand;
        if (memo.containsKey(key)) return memo.get(key);
        
        int res = Integer.MAX_VALUE;
        int nb = board.length();
        int nh = hand.length();
        
        for (int j = 0; j < nh; j++) {
            if (j > 0 && hand.charAt(j) == hand.charAt(j - 1)) continue;
            
            for (int i = 0; i <= nb; i++) {
                boolean isValidMove = false;
                
                if (i > 0 && board.charAt(i - 1) == hand.charAt(j)) isValidMove = true;
                if (i < nb && board.charAt(i) == hand.charAt(j)) isValidMove = true;
                if (i > 0 && i < nb && board.charAt(i - 1) == board.charAt(i) && board.charAt(i) != hand.charAt(j)) {
                    isValidMove = true;
                }
                
                if (!isValidMove) continue;
                
                String nextBoard = board.substring(0, i) + hand.charAt(j) + board.substring(i);
                nextBoard = removeConsecutive(nextBoard);
                String nextHand = hand.substring(0, j) + hand.substring(j + 1);
                
                int subRes = dfs(nextBoard, nextHand, memo);
                if (subRes != Integer.MAX_VALUE) {
                    res = Math.min(res, subRes + 1);
                }
            }
        }
        
        memo.put(key, res);
        return res;
    }

    private String removeConsecutive(String board) {
        int n = board.length();
        for (int i = 0; i < n; ) {
            int j = i;
            while (j < n && board.charAt(j) == board.charAt(i)) {
                j++;
            }
            if (j - i >= 3) {
                return removeConsecutive(board.substring(0, i) + board.substring(j));
            }
            i = j;
        }
        return board;
    }
}
