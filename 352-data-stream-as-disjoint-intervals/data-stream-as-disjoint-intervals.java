import java.util.TreeMap;

class SummaryRanges {
    private TreeMap<Integer, int[]> treeMap;

    public SummaryRanges() {
        treeMap = new TreeMap<>();
    }
    
    public void addNum(int value) {
        if (treeMap.containsKey(value)) {
            return;
        }
        
        Integer l = treeMap.lowerKey(value);
        Integer h = treeMap.higherKey(value);
        
        if (l != null && h != null && treeMap.get(l)[1] + 1 == value && h == value + 1) {
            treeMap.get(l)[1] = treeMap.get(h)[1];
            treeMap.remove(h);
        } else if (l != null && treeMap.get(l)[1] >= value - 1) {
            treeMap.get(l)[1] = Math.max(treeMap.get(l)[1], value);
        } else if (h != null && h == value + 1) {
            treeMap.put(value, new int[]{value, treeMap.get(h)[1]});
            treeMap.remove(h);
        } else {
            treeMap.put(value, new int[]{value, value});
        }
    }
    
    public int[][] getIntervals() {
        return treeMap.values().toArray(new int[treeMap.size()][]);
    }
}
