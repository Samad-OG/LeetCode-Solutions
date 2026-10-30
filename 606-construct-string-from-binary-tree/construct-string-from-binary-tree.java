class Solution {
    public String tree2str(TreeNode root) {
        if (root == null) {
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        
        if (root.left != null) {
            sb.append("(").append(tree2str(root.left)).append(")");
        } else if (root.right != null) {
            sb.append("()");
        }
        
        if (root.right != null) {
            sb.append("(").append(tree2str(root.right)).append(")");
        }
        
        return sb.toString();
    }
}
