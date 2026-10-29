import java.util.Scanner;

class Solution {
    public String fractionAddition(String expression) {
        Scanner sc = new Scanner(expression).useDelimiter("(?=[-+])");
        int num = 0, den = 1;
        
        while (sc.hasNext()) {
            String[] frac = sc.next().split("/");
            int n = Integer.parseInt(frac[0]);
            int d = Integer.parseInt(frac[1]);
            
            num = num * d + n * den;
            den = den * d;
            
            int g = Math.abs(gcd(num, den));
            num /= g;
            den /= g;
        }
        
        return num + "/" + den;
    }
    
    private int gcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
}
