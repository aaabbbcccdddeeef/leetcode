import java.util.Collections;
import java.util.LinkedList;

public class p394 {
    private int ptr;

    public String decodeString(String s) {
        LinkedList<String> stack = new LinkedList<>();
        ptr = 0;
        while (ptr < s.length()) {
            char ch = s.charAt(ptr);
            if (Character.isDigit(ch)) {
                stack.addLast(getDigit(s));
            } else if (Character.isLetter(ch) || ch == '[') {
                stack.addLast(String.valueOf(ch));
                ptr++;
            } else {
                ++ptr;
                LinkedList<String> ll = new LinkedList<>();
                while (!"[".equals(stack.peekLast())) {
                    ll.addLast(stack.removeLast());
                }
                Collections.reverse(ll);
                stack.removeLast();
                int rep = Integer.parseInt(stack.removeLast());
                StringBuilder sb = new StringBuilder();
                String o = getString(ll);
                while (rep-- > 0) {
                    sb.append(o);
                }
                stack.addLast(sb.toString());
            }
        }
        return getString(stack);
    }

    private String getDigit(String s) {
        String digit = "";
        while (Character.isDigit(s.charAt(ptr))) {
            digit += s.charAt(ptr++);
        }
        return digit;
    }

    private String getString(LinkedList<String> ll) {
        StringBuilder sb = new StringBuilder();
        for (String s : ll) {
            sb.append(s);
        }
        return sb.toString();
    }
}