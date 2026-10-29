import java.util.*;

class Solution {
    public List<Integer> postorder(Node root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) return res;
        
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        
        while (!stack.isEmpty()) {
            Node curr = stack.pop();
            res.addFirst(curr.val);
            
            if (curr.children != null) {
                for (Node child : curr.children) {
                    stack.push(child);
                }
            }
        }
        
        return res;
    }
}
