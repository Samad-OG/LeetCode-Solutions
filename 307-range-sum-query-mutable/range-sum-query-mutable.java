class NumArray {
    private int[] tree;
    private int[] nums;
    private int n;

    public NumArray(int[] nums) {
        this.nums = nums;
        this.n = nums.length;
        this.tree = new int[n + 1];
        for (int i = 0; i < n; i++) {
            init(i, nums[i]);
        }
    }

    private void init(int i, int val) {
        i++;
        while (i <= n) {
            tree[i] += val;
            i += i & (-i);
        }
    }

    public void update(int index, int val) {
        int delta = val - nums[index];
        nums[index] = val;
        int i = index + 1;
        while (i <= n) {
            tree[i] += delta;
            i += i & (-i);
        }
    }

    private int sum(int i) {
        int sum = 0;
        i++;
        while (i > 0) {
            sum += tree[i];
            i -= i & (-i);
        }
        return sum;
    }

    public int sumRange(int left, int right) {
        return sum(right) - sum(left - 1);
    }
}
