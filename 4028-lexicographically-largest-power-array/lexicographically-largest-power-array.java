import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] largestPower(int[] nums) {
        int[] power = new int[15];
        List<List<Integer>> blocks = new ArrayList<>();
        
        List<Integer> initialBlock = new ArrayList<>();
        for (int num : nums) {
            initialBlock.add(num);
        }
        blocks.add(initialBlock);
        
        for (int i = 0; i < 15; i++) {
            int bit = 14 - i;
            int count = 0;
            boolean stopCounting = false;
            List<List<Integer>> nextBlocks = new ArrayList<>();
            
            for (List<Integer> block : blocks) {
                if (stopCounting) {
                   
                    nextBlocks.add(block);
                    continue;
                }
                
                List<Integer> high = new ArrayList<>();
                List<Integer> low = new ArrayList<>();
                
                for (int num : block) {
                    if (((num >> bit) & 1) == 1) {
                        high.add(num);
                    } else {
                        low.add(num);
                    }
                }
                
                count += high.size();
                if (!low.isEmpty()) {
                    stopCounting = true;
                }
                
                if (!high.isEmpty()) {
                    nextBlocks.add(high);
                }
                if (!low.isEmpty()) {
                    nextBlocks.add(low);
                }
            }
            
            blocks = nextBlocks;
            power[i] = count;
        }
        
        return power;
    }
}
