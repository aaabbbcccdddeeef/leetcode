import java.util.Arrays;

public class p889 {
    // 字符串的最小表示法
    static public String orderlyQueue(String s, int m) {
        if (m == 1) {
            int i = 0, j = 1, k = 0, n = s.length();
            while (i < n && j < n && k < n) {
                char iCh = s.charAt((i + k) % n), jCh = s.charAt((j + k) % n);
                if (iCh == jCh)
                    k++;
                else {
                    if (iCh > jCh) {
                        i += k + 1;
                    } else {
                        j += k + 1;
                    }
                    if (i == j)
                        ++i;
                    k = 0;
                }

            }
            i = Math.min(i, j);
            return s.substring(i) + s.substring(0, i);
        } else {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            return String.valueOf(arr);
        }
    }

    public static void main(String[] args) {
        String s = "dbbca";
        orderlyQueue(s, 1);
    }
}
