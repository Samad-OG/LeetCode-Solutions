import java.util.*;

class Solution {
    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 1; i < n; i++) {
            adj.get(parent[i]).add(i);
        }

        int[] newParent = Arrays.copyOf(parent, n);
        int[] lastSeen = new int[26];
        Arrays.fill(lastSeen, -1);

        findNewParents(0, adj, s, lastSeen, newParent);

        List<List<Integer>> newAdj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            newAdj.add(new ArrayList<>());
        }
        for (int i = 1; i < n; i++) {
            newAdj.get(newParent[i]).add(i);
        }

        int[] answer = new int[n];
        computeSizes(0, newAdj, answer);
        return answer;
    }

    private void findNewParents(int u, List<List<Integer>> adj, String s, int[] lastSeen, int[] newParent) {
        int c = s.charAt(u) - 'a';
        int prev = lastSeen[c];
        if (prev != -1) {
            newParent[u] = prev;
        }
        lastSeen[c] = u;

        for (int v : adj.get(u)) {
            findNewParents(v, adj, s, lastSeen, newParent);
        }

        lastSeen[c] = prev;
    }

    private int computeSizes(int u, List<List<Integer>> adj, int[] answer) {
        int size = 1;
        for (int v : adj.get(u)) {
            size += computeSizes(v, adj, answer);
        }
        answer[u] = size;
        return size;
    }
}
