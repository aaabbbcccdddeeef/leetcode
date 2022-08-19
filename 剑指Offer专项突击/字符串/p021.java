public class p021 {
    public boolean validPalindrome(String s) {
        int n = s.length();
        int left = 0, right = n - 1;
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--))
                return validPalindrome(s, left, right + 1) || validPalindrome(s, left - 1, right);
        }
        return true;
    }

    public boolean validPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--))
                return false;
        }
        return true;
    }
}
