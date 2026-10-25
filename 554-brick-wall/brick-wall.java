import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Long, Integer> edgeCounts = new HashMap<>();
        int maxEdges = 0;
        
        for (List<Integer> row : wall) {
            long currentEdge = 0;
            for (int i = 0; i < row.size() - 1; i++) {
                currentEdge += row.get(i);
                int count = edgeCounts.getOrDefault(currentEdge, 0) + 1;
                edgeCounts.put(currentEdge, count);
                maxEdges = Math.max(maxEdges, count);
            }
        }
        
        return wall.size() - maxEdges;
    }
}
