import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class p761 {
    public String makeLargestSpecial(String s) {
        if (s == null || s.length() <= 2)
            return s;
        List<String> ans = new ArrayList<>();
        int left = 0, cnt = 0;
        for (int i = 0; i < s.length(); ++i) {
            cnt += s.charAt(i) == '1' ? 1 : -1;
            if (cnt == 0) {
                ans.add("1" + makeLargestSpecial(s.substring(left + 1, i)) + "0");
                left = i + 1;
            }
        }
        Collections.sort(ans, (a, b) -> b.compareTo(a));
        StringBuilder sb = new StringBuilder();
        for (String st : ans) {
            sb.append(st);
        }
        return sb.toString();
    }
}