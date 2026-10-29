import java.util.*;

class Solution {
    int[] tin, tout;
    int timer;
    int[][] up;
    int[] bit;
    int n;
    int[] currentMask;

    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {
        this.n = n;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        tin = new int[n];
        tout = new int[n];
        timer = 0;
        int l = (int) (Math.log(n) / Math.log(2)) + 1;
        up = new int[n][l + 1];
        currentMask = new int[n];
        for (int i = 0; i < n; i++) {
            currentMask[i] = 1 << (s.charAt(i) - 'a');
        }

        dfs(0, 0, adj);

        bit = new int[timer + 2];
        for (int i = 0; i < n; i++) {
            updateRange(tin[i], tout[i], currentMask[i]);
        }

        List<Boolean> ans = new ArrayList<>();
        for (String q : queries) {
            String[] parts = q.split(" ");
            if (parts[0].equals("update")) {
                int u = Integer.parseInt(parts[1]);
                char c = parts[2].charAt(0);
                int oldMask = currentMask[u];
                int newMask = 1 << (c - 'a');
                if (oldMask != newMask) {
                    currentMask[u] = newMask;
                    updateRange(tin[u], tout[u], oldMask ^ newMask);
                }
            } else {
                int u = Integer.parseInt(parts[1]);
                int v = Integer.parseInt(parts[2]);
                int lca = getLca(u, v);
                int maskU = queryPoint(tin[u]);
                int maskV = queryPoint(tin[v]);
                int maskLcaNode = currentMask[lca];
                int pathMask = maskU ^ maskV ^ maskLcaNode;
                ans.add((pathMask & (pathMask - 1)) == 0);
            }
        }
        return ans;
    }

    private void dfs(int u, int p, List<List<Integer>> adj) {
        tin[u] = ++timer;
        up[u][0] = p;
        for (int i = 1; i < up[u].length; i++) {
            up[u][i] = up[up[u][i - 1]][i - 1];
        }
        for (int v : adj.get(u)) {
            if (v != p) {
                dfs(v, u, adj);
            }
        }
        tout[u] = timer;
    }

    private boolean isAncestor(int u, int v) {
        return tin[u] <= tin[v] && tout[u] >= tout[v];
    }

    private int getLca(int u, int v) {
        if (isAncestor(u, v)) return u;
        if (isAncestor(v, u)) return v;
        for (int i = up[u].length - 1; i >= 0; i--) {
            if (!isAncestor(up[u][i], v)) {
                u = up[u][i];
            }
        }
        return up[u][0];
    }

    private void updateBIT(int idx, int val) {
        for (; idx < bit.length; idx += idx & -idx) {
            bit[idx] ^= val;
        }
    }

    private void updateRange(int l, int r, int val) {
        updateBIT(l, val);
        updateBIT(r + 1, val);
    }

    private int queryPoint(int idx) {
        int sum = 0;
        for (; idx > 0; idx -= idx & -idx) {
            sum ^= bit[idx];
        }
        return sum;
    }
}
