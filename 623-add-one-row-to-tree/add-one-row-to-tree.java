class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            return new TreeNode(val, root, null);
        }
        insert(root, val, 1, depth);
        return root;
    }

    private void insert(TreeNode node, int val, int currentDepth, int targetDepth) {
        if (node == null) {
            return;
        }
        if (currentDepth == targetDepth - 1) {
            node.left = new TreeNode(val, node.left, null);
            node.right = new TreeNode(val, null, node.right);
            return;
        }
        insert(node.left, val, currentDepth + 1, targetDepth);
        insert(node.right, val, currentDepth + 1, targetDepth);
    }
}
