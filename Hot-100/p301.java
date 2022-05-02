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

    int leftInvaild, rightInvalid;
    Set<String> ans;

    public List<String> removeInvalidParentheses(String s) {
        leftInvaild = rightInvalid = 0;
        ans = new HashSet<>();
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
        backtrack("", s, 0, leftInvaild, rightInvalid, 0, 0);
        List<String> lst = new ArrayList<>(ans.stream().toList());
        return lst;
    }

    private void backtrack(String res, String s, int idx, int leftRe, int rightRe, int l, int r) {
        StringBuilder sb = new StringBuilder(res);
        // ignore letters
        while (idx < s.length() && s.charAt(idx) != '(' && s.charAt(idx) != ')') {
            sb.append(s.charAt(idx++));
        }
        // reach end and '(' count=0, ')' count=0
        if (idx == s.length()) {
            if (l == 0 && r == 0) {
                ans.add(sb.toString());
            }
            return;
        }
        char ch = s.charAt(idx);
        if (ch == '(' && leftRe > 0) {
            backtrack(sb.toString(), s, ++idx, --leftRe, rightRe, l, r);
            --idx;
            ++leftRe;
        }
        if (ch == ')' && rightRe > 0) {
            backtrack(sb.toString(), s, ++idx, leftRe, --rightRe, l, r);
            --idx;
            ++rightRe;
        }
        if (leftRe == 0 && rightRe == 0) {
            String tmp = sb.toString() + s.substring(idx);
            if (isValid(tmp)) {
                ans.add(tmp);
            }
            return;
        }
        // don't remove '(' or ')'
        if (ch == '(') {
            sb.append('(');
            l++;
        } else if (ch == ')') {
            sb.append(')');
            if (l != 0) {
                l--;
            } else {
                r++;
            }
        }
        if (r != 0) {
            return;
        }
        backtrack(sb.toString(), s, ++idx, leftRe, rightRe, l, r);
    }

    private static boolean isValid(String s) {
        int l = 0, r = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                l++;
            } else if (ch == ')') {
                if (l != 0) {
                    l--;
                } else {
                    return false;
                }
            }
        }
        return l == 0 && r == 0;
    }
}
