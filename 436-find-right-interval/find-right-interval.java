import java.util.TreeMap;

class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[] result = new int[n];
        TreeMap<Integer, Integer> startMap = new TreeMap<>();
        
        for (int i = 0; i < n; i++) {
            startMap.put(intervals[i][0], i);
        }
        
        for (int i = 0; i < n; i++) {
            Integer ceilingKey = startMap.ceilingKey(intervals[i][1]);
            result[i] = (ceilingKey == null) ? -1 : startMap.get(ceilingKey);
        }
        
        return result;
    }
}
