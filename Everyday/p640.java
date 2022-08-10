public class p640 {
    public String solveEquation(String eq) {
        if (eq == null || !eq.contains("="))
            return null;
        int n = eq.length();
        int coef = 0, num = 0, op = 1;
        for (int i = 0; i < n;) {
            if (eq.charAt(i) == '+') {
                op = 1;
                ++i;
            } else if (eq.charAt(i) == '-') {
                op = -1;
                ++i;
            } else if (eq.charAt(i) == '=') {
                op = 1;
                coef = -coef;
                num = -num;
                ++i;
            } else {
                // if 'x' or a number
                int j = i;
                // find where ends
                while (j < n && eq.charAt(j) != '+' && eq.charAt(j) != '-' && eq.charAt(j) != '=')
                    ++j;
                // if the last char is 'x', judge its coefficient
                if (eq.charAt(j - 1) == 'x')
                    coef += op * (i == j - 1 ? 1 : Integer.parseInt(eq.substring(i, j - 1)));
                else
                // judge the number
                    num += op * Integer.parseInt(eq.substring(i, j));
                i = j;
            }
        }
        return coef == 0 ? num == 0 ? "Infinite solutions" : "No solution" : "x=" + (-num / coef);
    }
}
