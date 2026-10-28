class Solution {
    private int totalTilt = 0;

    public int findTilt(TreeNode root) {
        totalTilt = 0;
        valueSum(root);
        return totalTilt;
    }

    private int valueSum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        
        int leftSum = valueSum(node.left);
        int rightSum = valueSum(node.right);
        
        totalTilt += Math.abs(leftSum - rightSum);
        
        return node.val + leftSum + rightSum;
    }
}
