class Solution {
    public String validIPAddress(String queryIP) {
        if (queryIP.chars().filter(ch -> ch == '.').count() == 3) {
            return validateIPv4(queryIP);
        } else if (queryIP.chars().filter(ch -> ch == ':').count() == 7) {
            return validateIPv6(queryIP);
        }
        return "Neither";
    }

    private String validateIPv4(String ip) {
        String[] nums = ip.split("\\.", -1);
        for (String x : nums) {
            if (x.length() == 0 || x.length() > 3) {
                return "Neither";
            }
            if (x.charAt(0) == '0' && x.length() != 1) {
                return "Neither";
            }
            for (char ch : x.toCharArray()) {
                if (!Character.isDigit(ch)) {
                    return "Neither";
                }
            }
            int val = Integer.parseInt(x);
            if (val < 0 || val > 255) {
                return "Neither";
            }
        }
        return "IPv4";
    }

    private String validateIPv6(String ip) {
        String[] nums = ip.split(":", -1);
        String hexdigits = "0123456789abcdefABCDEF";
        for (String x : nums) {
            if (x.length() == 0 || x.length() > 4) {
                return "Neither";
            }
            for (char ch : x.toCharArray()) {
                if (hexdigits.indexOf(ch) == -1) {
                    return "Neither";
                }
            }
        }
        return "IPv6";
    }
}
