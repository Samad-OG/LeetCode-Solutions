import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int[] nums, int index, List<Integer> current, List<List<Integer>> res) {
        if (current.size() >= 2) {
            res.add(new ArrayList<>(current));
        }

        Set<Integer> used = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            if (!current.isEmpty() && nums[i] < current.get(current.size() - 1)) {
                continue;
            }
            if (used.contains(nums[i])) {
                continue;
            }

            used.add(nums[i]);
            current.add(nums[i]);
            backtrack(nums, i + 1, current, res);
            current.remove(current.size() - 1);
        }
    }
}
