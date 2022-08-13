import java.util.ArrayDeque;
import java.util.Deque;

public class p388 {
    public int lengthLongestPath(String input) {
        // dfs with stack
        if (input == null)
            return 0;
        // stk used to store each in-path's lengh
        // the stk path represent the depth of peek-path
        Deque<Integer> stk = new ArrayDeque<>();
        int n = input.length();
        int pos = 0, ans = 0;
        while (pos < n) {
            // default depth is 1
            int depth = 1;
            // count current depth
            while (pos < n && input.charAt(pos) == '\t') {
                ++pos;
                ++depth;
            }
            // judge if current path is a file
            boolean isFile = false;
            int len = 0;
            while (pos < n && input.charAt(pos) != '\n') {
                if (input.charAt(pos) == '.')
                    isFile = true;
                ++len;
                ++pos;
            }
            // jump over the '\n'
            ++pos;

            // judge if out of stack's in-path
            while (stk.size() >= depth)
                stk.pop();
            // calculate current path length, 1 for '/'
            len += stk.isEmpty() ? 0 : stk.peek() + 1;
            if (isFile) {
                ans = Math.max(ans, len);
            } else {
                stk.push(len);
            }
        }
        return ans;
    }
}