import java.util.HashMap;
import java.util.Map;

class Solution {
    private static final int MOD = 1_000_000_007;

    static class SegmentTree {
        int n;
        long[] sum;
        long[] sqSum;
        long[] lazy;

        SegmentTree(int n) {
            this.n = n;
            sum = new long[4 * n];
            sqSum = new long[4 * n];
            lazy = new long[4 * n];
        }

        void pushUp(int node) {
            sum[node] = (sum[2 * node] + sum[2 * node + 1]) % MOD;
            sqSum[node] = (sqSum[2 * node] + sqSum[2 * node + 1]) % MOD;
        }

        void pushDown(int node, int l, int r) {
            if (lazy[node] == 0) return;
            long val = lazy[node];
            int mid = (l + r) >> 1;
            
            updateNode(2 * node, l, mid, val);
            updateNode(2 * node + 1, mid + 1, r, val);
            
            lazy[node] = 0;
        }

        void updateNode(int node, int l, int r, long val) {
            long len = r - l + 1;
            sqSum[node] = (sqSum[node] + 2 * val % MOD * sum[node] % MOD + val * val % MOD * len % MOD) % MOD;
            sum[node] = (sum[node] + val * len) % MOD;
            lazy[node] = (lazy[node] + val) % MOD;
        }

        void update(int node, int start, int end, int l, int r, long val) {
            if (l <= start && end <= r) {
                updateNode(node, start, end, val);
                return;
            }
            pushDown(node, start, end);
            int mid = (start + end) >> 1;
            if (l <= mid) update(2 * node, start, mid, l, r, val);
            if (r > mid) update(2 * node + 1, mid + 1, end, l, r, val);
            pushUp(node);
        }
    }

    public int sumCounts(int[] nums) {
        int n = nums.length;
        SegmentTree tree = new SegmentTree(n);
        Map<Integer, Integer> lastSeen = new HashMap<>();
        long totalSum = 0;

        for (int r = 0; r < n; r++) {
            int l = lastSeen.getOrDefault(nums[r], -1) + 1;
            tree.update(1, 0, n - 1, l, r, 1);
            lastSeen.put(nums[r], r);
            totalSum = (totalSum + tree.sqSum[1]) % MOD;
        }

        return (int) ((totalSum + MOD) % MOD);
    }
}
