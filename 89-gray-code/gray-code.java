import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        int numElements = 1 << n;
        
        for (int i = 0; i < numElements; i++) {
            result.add(i ^ (i >> 1));
        }
        
        return result;
    }
}
