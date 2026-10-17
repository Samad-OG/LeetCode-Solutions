class Solution {
    public int largestPalindrome(int n) {
        if (n == 1) {
            return 9;
        }
        
        long upper = (long) Math.pow(10, n) - 1;
        long lower = (long) Math.pow(10, n - 1);
        
        for (long i = upper; i >= lower; i--) {
            long palindrome = createPalindrome(i);
            
            for (long j = upper; j * j >= palindrome; j--) {
                if (palindrome % j == 0) {
                    return (int) (palindrome % 1337);
                }
            }
        }
        
        return -1;
    }

    private long createPalindrome(long num) {
        String s = Long.toString(num);
        String reversed = new StringBuilder(s).reverse().toString();
        return Long.parseLong(s + reversed);
    }
}
