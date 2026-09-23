import java.util.HashMap;
import java.util.Map;

class Solution {
    private int postorderIndex;
    private Map<Integer, Integer> inorderIndexMap;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postorderIndex = postorder.length - 1;
        inorderIndexMap = new HashMap<>();
        
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return arrayToTree(postorder, 0, inorder.length - 1);
    }

    private TreeNode arrayToTree(int[] postorder, int left, int right) {
        if (left > right) {
            return null;
        }

        int rootValue = postorder[postorderIndex--];
        TreeNode root = new TreeNode(rootValue);

        int inorderRootIndex = inorderIndexMap.get(rootValue);

        root.right = arrayToTree(postorder, inorderRootIndex + 1, right);
        root.left = arrayToTree(postorder, left, inorderRootIndex - 1);

        return root;
    }
}
