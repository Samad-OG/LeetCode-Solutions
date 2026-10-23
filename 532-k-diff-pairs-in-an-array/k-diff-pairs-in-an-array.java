import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findPairs(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int count = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int val = entry.getValue();

            if (k == 0) {
                if (val >= 2) {
                    count++;
                }
            } else {
                if (map.containsKey(key + k)) {
                    count++;
                }
            }
        }

        return count;
    }
}
