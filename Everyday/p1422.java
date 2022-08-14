public class p1422 {
    public int maxScore(String s) {
        if (s == null)
            return 0;
        int total1 = 0;
        for (var ch : s.toCharArray()) {
            if (ch == '1')
                ++total1;
        }
        int left0 = 0, right1 = total1;
        int ans = 0;
        for (int i = 0; i < s.length() - 1; ++i) {
            if (s.charAt(i) == '1')
                --right1;
            else
                ++left0;
            ans = Math.max(ans, left0 + right1);
        }
        return ans;
    }
}
