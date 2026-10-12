class Solution {
    public int strongPasswordChecker(String password) {
        int n = password.length();
        int hasLower = 0, hasUpper = 0, hasDigit = 0;
        
        for (char c : password.toCharArray()) {
            if (Character.isLowerCase(c)) hasLower = 1;
            else if (Character.isUpperCase(c)) hasUpper = 1;
            else if (Character.isDigit(c)) hasDigit = 1;
        }
        
        int missingTypes = 3 - (hasLower + hasUpper + hasDigit);
        
        if (n < 6) {
            return Math.max(6 - n, missingTypes);
        }
        
        int replaces = 0;
        int oneMod3 = 0;
        int twoMod3 = 0;
        
        int i = 0;
        while (i < n) {
            int len = 1;
            while (i + 1 < n && password.charAt(i) == password.charAt(i + 1)) {
                len++;
                i++;
            }
            if (len >= 3) {
                replaces += len / 3;
                if (len % 3 == 0) oneMod3++;
                else if (len % 3 == 1) twoMod3++;
            }
            i++;
        }
        
        if (n <= 20) {
            return Math.max(replaces, missingTypes);
        }
        
        int deletes = n - 20;
        
        replaces -= Math.min(deletes, oneMod3 * 1) / 1;
        int remainingDeletes = deletes - Math.min(deletes, oneMod3 * 1);
        
        replaces -= Math.min(remainingDeletes, twoMod3 * 2) / 2;
        remainingDeletes -= Math.min(remainingDeletes, twoMod3 * 2);
        
        replaces -= remainingDeletes / 3;
        
        return deletes + Math.max(replaces, missingTypes);
    }
}
