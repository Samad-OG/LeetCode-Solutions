import java.util.HashMap;
import java.util.Map;
import java.util.Random;

class Solution {
    private Map<Integer, Integer> map;
    private int rows;
    private int cols;
    private int total;
    private Random rand;

    public Solution(int m, int n) {
        this.rows = m;
        this.cols = n;
        this.total = m * n;
        this.map = new HashMap<>();
        this.rand = new Random();
    }
    
    public int[] flip() {
        int r = rand.nextInt(total);
        total--;
        
        int idx = map.getOrDefault(r, r);
        int last = map.getOrDefault(total, total);
        
        map.put(r, last);
        
        return new int[]{idx / cols, idx % cols};
    }
    
    public void reset() {
        map.clear();
        total = rows * cols;
    }
}
