class Solution {
    public int minCut(String s) {
        int n = s.length();
        if (n <= 1) return 0;
        
        int[] cuts = new int[n];
        boolean[][] isPal = new boolean[n][n];
        
        for (int i = 0; i < n; i++) {
            cuts[i] = i;
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i - j < 2 || isPal[j + 1][i - 1])) {
                    isPal[j][i] = true;
                    if (j == 0) {
                        cuts[i] = 0;
                    } else {
                        cuts[i] = Math.min(cuts[i], cuts[j - 1] + 1);
                    }
                }
            }
        }
        
        return cuts[n - 1];
    }
}
