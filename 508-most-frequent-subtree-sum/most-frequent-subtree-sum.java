import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    private Map<Integer, Integer> countMap;
    private int maxCount;

    public int[] findFrequentTreeSum(TreeNode root) {
        countMap = new HashMap<>();
        maxCount = 0;
        
        getSum(root);
        
        List<Integer> resultList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == maxCount) {
                resultList.add(entry.getKey());
            }
        }
        
        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        
        return result;
    }

    private int getSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int leftSum = getSum(root.left);
        int rightSum = getSum(root.right);
        int sum = root.val + leftSum + rightSum;
        
        int count = countMap.getOrDefault(sum, 0) + 1;
        countMap.put(sum, count);
        maxCount = Math.max(maxCount, count);
        
        return sum;
    }
}
