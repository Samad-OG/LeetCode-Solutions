import java.math.BigInteger;

class Solution {
    public String smallestGoodBase(String n) {
        long num = Long.parseLong(n);
        
        for (int m = (int) (Math.log(num + 1) / Math.log(2)); m >= 2; m--) {
            long k = (long) Math.pow(num, 1.0 / m);
            if (k >= 2) {
                long sum = 0;
                long res = 1;
                for (int i = 0; i <= m; i++) {
                    sum += res;
                    res *= k;
                }
                if (sum == num) {
                    return String.valueOf(k);
                }
                
                sum = 0;
                res = 1;
                for (int i = 0; i < m; i++) {
                    sum += res;
                    res *= k;
                }
                if (sum == num) {
                    return String.valueOf(k);
                }
            }
        }
        
        return String.valueOf(num - 1);
    }
}
