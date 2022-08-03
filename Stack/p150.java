import java.util.ArrayDeque;
import java.util.Deque;

public class p150 {
    static public int evalRPN(String[] tokens) {
        Deque<Integer> stk = new ArrayDeque<>();
        int n = tokens.length;
        for (int i = 0; i < n; ++i) {
            if (tokens[i].length() == 1 && !Character.isDigit(tokens[i].charAt(0))) {
                int b = stk.pop(), a = stk.pop();
                switch (tokens[i]) {
                    case "+":
                        a += b;
                        break;
                    case "-":
                        a -= b;
                        break;
                    case "*":
                        a *= b;
                        break;
                    case "/":
                        a /= b;
                }
                stk.push(a);
            } else {
                stk.push(Integer.parseInt(tokens[i]));
            }
        }
        return stk.peek();
    }

    public static void main(String[] args) {
        String[] tc = { "10","6","9","3","+","-11","*","/","*","17","+","5","+" };
        evalRPN(tc);
    }
}
