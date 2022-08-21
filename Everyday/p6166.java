public class p6166 {
    public String largestPalindromic(String num) {
        int[] cnt = new int[10];
        boolean evenExist = false;
        for (char i : num.toCharArray()) {
            ++cnt[i - '0'];
            if (!evenExist && i != '0' && cnt[i - '0'] >= 2)
                evenExist = true;
        }
        int mid = -1;
        for (int i = 0; i < 10; ++i) {
            if (cnt[i] != 0 && cnt[i] % 2 == 1)
                mid = i;
        }
        if (!evenExist) {
            if (mid == -1)
                return "0";
            return String.valueOf(mid);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; ++i) {
            for (int j = 0; j < cnt[i] / 2; ++j)
                sb.append(i);
        }
        String postfix = sb.toString();
        String midString = mid == -1 ? "" : String.valueOf(mid);
        return sb.reverse().toString() + midString + postfix;
    }
}
