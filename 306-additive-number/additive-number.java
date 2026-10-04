import java.math.BigInteger;

class Solution {
    public boolean isAdditiveNumber(String num) {
        int n = num.length();
        for (int i = 1; i <= n / 2; i++) {
            if (num.charAt(0) == '0' && i > 1) break;
            for (int j = 1; Math.max(i, j) <= n - i - j; j++) {
                if (num.charAt(i) == '0' && j > 1) break;
                if (isValid(i, j, num)) return true;
            }
        }
        return false;
    }

    private boolean isValid(int i, int j, String num) {
        BigInteger n1 = new BigInteger(num.substring(0, i));
        BigInteger n2 = new BigInteger(num.substring(i, i + j));
        String remaining = num.substring(i + j);
        
        while (!remaining.isEmpty()) {
            BigInteger sum = n1.add(n2);
            String sumStr = sum.toString();
            if (!remaining.startsWith(sumStr)) return false;
            remaining = remaining.substring(sumStr.length());
            n1 = n2;
            n2 = sum;
        }
        return true;
    }
}
