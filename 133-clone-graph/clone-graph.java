import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Map<Node, Node> visited = new HashMap<>();
        return clone(node, visited);
    }

    private Node clone(Node node, Map<Node, Node> visited) {
        if (visited.containsKey(node)) {
            return visited.get(node);
        }
        
        Node copy = new Node(node.val, new ArrayList<>());
        visited.put(node, copy);
        
        for (Node neighbor : node.neighbors) {
            copy.neighbors.add(clone(neighbor, visited));
        }
        
        return copy;
    }
}
