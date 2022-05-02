import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class p301 {
    public static void main(String[] args) {
        String s = ")(";
        p301 p = new p301();
        System.out.println(p.removeInvalidParentheses(s));
    }

    List<String> ans;

    public List<String> removeInvalidParentheses(String s) {
        int leftInvaild = 0, rightInvalid = 0;
        ans = new ArrayList<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                leftInvaild++;
            } else if (ch == ')') {
                if (leftInvaild != 0) {
                    leftInvaild--;
                } else {
                    rightInvalid++;
                }
            }
        }
        backtrack(s, 0, leftInvaild, rightInvalid);
        return ans;
    }

    private void backtrack(String s, int idx, int leftRe, int rightRe) {
        if (leftRe == 0 && rightRe == 0) {
            if (isValid(s)) {
                ans.add(s);
            }
            return;
        }
        for (int i = idx; i < s.length(); i++) {
            if (leftRe + rightRe + i > s.length()) {
                return;
            }
            if (i != idx && s.charAt(i) == s.charAt(i - 1)) {
                continue;
            }
            if (leftRe > 0 && s.charAt(i) == '(') {
                backtrack(s.substring(0, i) + s.substring(i + 1), i, leftRe - 1, rightRe);
            }
            if (rightRe > 0 && s.charAt(i) == ')') {
                backtrack(s.substring(0, i) + s.substring(i + 1), i, leftRe, rightRe - 1);
            }
        }
    }

    private static boolean isValid(String s) {
        int cnt = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                cnt++;
            } else if (ch == ')') {
                if (cnt == 0) {
                    return false;
                }
                cnt--;
            }
        }
        return cnt == 0;
    }
}
