import java.util.Arrays;

class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        long[] distances = new long[] {
            dist(p1, p2), dist(p1, p3), dist(p1, p4),
            dist(p2, p3), dist(p2, p4), dist(p3, p4)
        };
        
        Arrays.sort(distances);
        
        return distances[0] > 0 &&
               distances[0] == distances[1] &&
               distances[1] == distances[2] &&
               distances[2] == distances[3] &&
               distances[4] == distances[5] &&
               distances[3] < distances[4];
    }
    
    private long dist(int[] a, int[] b) {
        return (long) (a[0] - b[0]) * (a[0] - b[0]) + (long) (a[1] - b[1]) * (a[1] - b[1]);
    }
}
