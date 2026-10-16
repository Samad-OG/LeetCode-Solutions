import java.util.HashMap;
import java.util.Map;

class Solution {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        int len1 = s1.length();
        int len2 = s2.length();
        
        int s1Count = 0;
        int s2Count = 0;
        int i1 = 0;
        int i2 = 0;
        
        Map<Integer, int[]> memo = new HashMap<>();
        
        while (s1Count < n1) {
            if (s1.charAt(i1) == s2.charAt(i2)) {
                i2++;
                if (i2 == len2) {
                    i2 = 0;
                    s2Count++;
                }
            }
            i1++;
            if (i1 == len1) {
                i1 = 0;
                s1Count++;
                
                if (memo.containsKey(i2)) {
                    int[] prev = memo.get(i2);
                    int prevS1Count = prev[0];
                    int prevS2Count = prev[1];
                    
                    int cycleS1 = s1Count - prevS1Count;
                    int cycleS2 = s2Count - prevS2Count;
                    
                    int remainingS1 = n1 - s1Count;
                    int cycles = remainingS1 / cycleS1;
                    
                    s1Count += cycles * cycleS1;
                    s2Count += cycles * cycleS2;
                } else {
                    memo.put(i2, new int[]{s1Count, s2Count});
                }
            }
        }
        
        return s2Count / n2;
    }
}
