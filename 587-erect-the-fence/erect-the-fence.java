import java.util.*;

class Solution {
    public int[][] outerTrees(int[][] trees) {
        if (trees.length <= 3) return trees;
        
        Arrays.sort(trees, (a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));
        
        List<int[]> lower = new ArrayList<>();
        for (int[] p : trees) {
            while (lower.size() >= 2 && crossProduct(lower.get(lower.size() - 2), lower.get(lower.size() - 1), p) < 0) {
                lower.remove(lower.size() - 1);
            }
            lower.add(p);
        }
        
        List<int[]> upper = new ArrayList<>();
        for (int i = trees.length - 1; i >= 0; i--) {
            int[] p = trees[i];
            while (upper.size() >= 2 && crossProduct(upper.get(upper.size() - 2), upper.get(upper.size() - 1), p) < 0) {
                upper.remove(upper.size() - 1);
            }
            upper.add(p);
        }
        
        Set<int[]> set = new HashSet<>();
        set.addAll(lower);
        set.addAll(upper);
        
        return set.toArray(new int[set.size()][]);
    }
    
    private int crossProduct(int[] o, int[] a, int[] b) {
        return (a[0] - o[0]) * (b[1] - o[1]) - (a[1] - o[1]) * (b[0] - o[0]);
    }
}
