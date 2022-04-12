public class p647 {
    public int countSubstrings(String s) {
        int sLen = s.length();
        int ans = sLen;
        // for odd length Palindromic
        for (int i = 1; i < sLen - 1; i++) {
            for (int armLen = 1; i - armLen >= 0 && i + armLen < sLen; armLen++) {
                if (s.charAt(i - armLen) != s.charAt(i + armLen)) {
                    break;
                }
                ans++;
            }
        }
        // for even length
        for (int i = 0; i < sLen - 1; i++) {
            for (int armLen = 0; i - armLen >= 0 && i + 1 + armLen < sLen; armLen++) {
                if (s.charAt(i - armLen) != s.charAt(i + 1 + armLen)) {
                    break;
                }
                ans++;
            }
        }
        return ans;
    }
}
