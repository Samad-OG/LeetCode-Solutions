import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        findPaths(root, targetSum, new ArrayList<>(), result);
        return result;
    }

    private void findPaths(TreeNode node, int remainingSum, List<Integer> currentPath, List<List<Integer>> result) {
        if (node == null) {
            return;
        }

        currentPath.add(node.val);

        if (node.left == null && node.right == null && remainingSum == node.val) {
            result.add(new ArrayList<>(currentPath));
        } else {
            findPaths(node.left, remainingSum - node.val, currentPath, result);
            findPaths(node.right, remainingSum - node.val, currentPath, result);
        }

        currentPath.remove(currentPath.size() - 1);
    }
}
