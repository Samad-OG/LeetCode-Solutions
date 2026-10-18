import java.util.Random;
import java.util.TreeMap;

class Solution {
    private int[][] rects;
    private TreeMap<Integer, Integer> map;
    private int totalArea;
    private Random rand;

    public Solution(int[][] rects) {
        this.rects = rects;
        this.map = new TreeMap<>();
        this.totalArea = 0;
        this.rand = new Random();

        for (int i = 0; i < rects.length; i++) {
            int[] r = rects[i];
            int area = (r[2] - r[0] + 1) * (r[3] - r[1] + 1);
            totalArea += area;
            map.put(totalArea, i);
        }
    }
    
    public int[] pick() {
        int target = rand.nextInt(totalArea) + 1;
        int rectIndex = map.ceilingEntry(target).getValue();
        int[] r = rects[rectIndex];
        
        int x = r[0] + rand.nextInt(r[2] - r[0] + 1);
        int y = r[1] + rand.nextInt(r[3] - r[1] + 1);
        
        return new int[]{x, y};
    }
}
