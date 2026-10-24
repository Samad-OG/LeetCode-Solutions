class Solution {
    public String complexNumberMultiply(String num1, String num2) {
        String[] split1 = num1.split("\\+|i");
        String[] split2 = num2.split("\\+|i");

        int r1 = Integer.parseInt(split1[0]);
        int i1 = Integer.parseInt(split1[1]);
        int r2 = Integer.parseInt(split2[0]);
        int i2 = Integer.parseInt(split2[1]);

        int realRes = r1 * r2 - i1 * i2;
        int imagRes = r1 * i2 + i1 * r2;

        return realRes + "+" + imagRes + "i";
    }
}
