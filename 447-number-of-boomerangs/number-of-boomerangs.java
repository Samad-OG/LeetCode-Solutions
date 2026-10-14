import java.util.HashMap;
import java.util.Map;

class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int totalBoomerangs = 0;
        Map<Integer, Integer> distanceMap = new HashMap<>();

        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (i == j) continue;

                int dx = points[i][0] - points[j][0];
                int dy = points[i][1] - points[j][1];
                int distSq = dx * dx + dy * dy;

                distanceMap.put(distSq, distanceMap.getOrDefault(distSq, 0) + 1);
            }

            for (int count : distanceMap.values()) {
                totalBoomerangs += count * (count - 1);
            }

            distanceMap.clear();
        }

        return totalBoomerangs;
    }
}
