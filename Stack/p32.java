import java.util.ArrayDeque;
import java.util.Deque;

public class p32 {
    // 此题有感：1.提前做好test case。2.本地测试再上传测试，避免面向错误tc编程
    static public int longestValidParentheses(String s) {
        if (s == null) {
            return 0;
        }
        Deque<Integer> stack = new ArrayDeque<>();
        int n = s.length(), maxAns = 0;
        stack.push(-1);
        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    // last elements
                    stack.push(i);
                } else {
                    maxAns = Math.max(maxAns, i - stack.peek());
                }
            }
        }
        return maxAns;
    }

    public static void main(String[] args) {
        String s = "(()";
        System.out.println(longestValidParentheses(s));
        s = "()(())(()()(())(()";
        System.out.println(longestValidParentheses(s));
    }
}
