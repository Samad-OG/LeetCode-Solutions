import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }

        Set<Integer> intersectSet = new HashSet<>();
        for (int num : nums2) {
            if (set1.contains(num)) {
                intersectSet.add(num);
            }
        }

        int[] result = new int[intersectSet.size()];
        int i = 0;
        for (int num : intersectSet) {
            result[i++] = num;
        }

        return result;
    }
}
