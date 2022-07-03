public class p567 {
    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return false;
        }
        int m = s1.length(), n = s2.length();
        if (m > n) {
            return false;
        }
        int cnt[] = new int[26];
        for (char ch : s1.toCharArray()) {
            ++cnt[ch - 'a'];
        }
        int r = 0;
        for (int l = 0; l <= n - m; l++) {
            while (r < l + m && cnt[s2.charAt(r) - 'a'] > 0) {
                --cnt[s2.charAt(r++) - 'a'];
            }
            if (r == l + m) {
                return true;
            }
            ++cnt[s2.charAt(l) - 'a'];
        }
        return false;
    }
}
