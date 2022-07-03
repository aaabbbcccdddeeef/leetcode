import java.util.ArrayList;
import java.util.List;

public class p763 {
    public List<Integer> partitionLabels(String s) {
        if (s == null) {
            return null;
        }
        List<Integer> ans = new ArrayList<>();
        int n = s.length();
        int lastPos[] = new int[26];
        for (int i = 0; i < n; i++) {
            lastPos[s.charAt(i) - 'a'] = Math.max(lastPos[s.charAt(i) - 'a'], i);
        }
        int begin = 0, end = 0;
        for (int i = 0; i < n; ++i) {
            end = Math.max(lastPos[s.charAt(i) - 'a'], end);
            if (i == end) {
                ans.add(end - begin + 1);
                begin = end + 1;
            }
        }
        return ans;
    }
}
