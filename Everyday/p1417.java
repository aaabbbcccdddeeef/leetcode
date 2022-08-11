public class p1417 {
    public String reformat(String s) {
        if (s == null)
            return null;
        int n = s.length();
        char[] ans = new char[n];
        int cNum = 0;
        for (char c : s.toCharArray())
            cNum += Character.isDigit(c) ? 0 : 1;
        if (Math.abs(n - cNum * 2) > 1)
            return "";
        int cIdx = n > cNum * 2 ? 1 : 0;
        int dIdx = cIdx == 0 ? 1 : 0;
        for (int i = 0; i < n; ++i) {
            if (Character.isDigit(s.charAt(i))) {
                ans[dIdx] = s.charAt(i);
                dIdx+=2;
            } else {
                ans[cIdx] = s.charAt(i);
                cIdx+=2;
            }
        }
        return String.valueOf(ans);
    }
}