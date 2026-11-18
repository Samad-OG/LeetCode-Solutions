class Solution {
    public String solveEquation(String equation) {
        String[] parts = equation.split("=");
        int[] left = evaluate(parts[0]);
        int[] right = evaluate(parts[1]);

        int coeff = left[0] - right[0];
        int constant = right[1] - left[1];

        if (coeff == 0) {
            return constant == 0 ? "Infinite solutions" : "No solution";
        }

        return "x=" + (constant / coeff);
    }

    private int[] evaluate(String expr) {
        int coeff = 0;
        int constant = 0;
        int sign = 1;
        int i = 0;
        int n = expr.length();

        while (i < n) {
            if (expr.charAt(i) == '+') {
                sign = 1;
                i++;
            } else if (expr.charAt(i) == '-') {
                sign = -1;
                i++;
            }

            int num = 0;
            boolean hasNum = false;
            while (i < n && Character.isDigit(expr.charAt(i))) {
                num = num * 10 + (expr.charAt(i) - '0');
                hasNum = true;
                i++;
            }

            if (i < n && expr.charAt(i) == 'x') {
                coeff += sign * (hasNum ? num : 1);
                i++;
            } else {
                constant += sign * num;
            }
        }

        return new int[]{coeff, constant};
    }
}
