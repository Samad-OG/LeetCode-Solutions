import java.util.*;

class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        List<int[]>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            adj[edge[0]].add(new int[]{edge[1], edge[2]});
        }

        int maxK = Math.min(k, n);
        int[][] dist = new int[n][maxK + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        
        dist[0][1] = 0;
        pq.offer(new int[]{0, 0, 1});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int d = curr[0];
            int u = curr[1];
            int c = curr[2];

            if (d > dist[u][c]) continue;
            if (u == n - 1) return d;

            for (int[] edge : adj[u]) {
                int v = edge[0];
                int w = edge[1];
                
                int nextC = (labels.charAt(v) == labels.charAt(u)) ? c + 1 : 1;
                
                if (nextC <= maxK) {
                    if (d + w < dist[v][nextC]) {
                        dist[v][nextC] = d + w;
                        pq.offer(new int[]{dist[v][nextC], v, nextC});
                    }
                }
            }
        }

        return -1;
    }
}
