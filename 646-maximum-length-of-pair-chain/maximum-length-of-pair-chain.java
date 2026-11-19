import java.util.Arrays;

class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[1], b[1]));
        
        int currentEnd = Integer.MIN_VALUE;
        int chainLength = 0;
        
        for (int[] pair : pairs) {
            if (pair[0] > currentEnd) {
                chainLength++;
                currentEnd = pair[1];
            }
        }
        
        return chainLength;
    }
}
