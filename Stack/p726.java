import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class p726 {
    String formula;
    int idx, len;

    public String countOfAtoms(String fml) {
        this.formula = fml;
        this.idx = 0;
        this.len = formula.length();
        Deque<Map<String, Integer>> stack = new ArrayDeque<>();
        stack.push(new HashMap<String, Integer>());
        while (idx < len) {
            switch (formula.charAt(idx)) {
                case '(':
                    stack.push(new HashMap<String, Integer>());
                    idx++;
                    break;
                case ')':
                    idx++;
                    Map<String, Integer> innerMap = stack.pop();
                    Map<String, Integer> outerMap = stack.peek();
                    int cnt = nextNum();
                    // multiple the inner cnt with the )n's n, and join to the outerMap
                    for (String s : innerMap.keySet()) {
                        outerMap.put(s, outerMap.getOrDefault(s, 0) + innerMap.get(s) * cnt);
                    }
                    break;
                default:
                    Map<String, Integer> map = stack.peek();
                    String atom = nextAtom();
                    int n = nextNum();
                    map.put(atom, map.getOrDefault(atom, 0) + n);
            }
        }
        TreeMap<String, Integer> treeMap = new TreeMap<>(stack.peek());
        StringBuilder sb = new StringBuilder();
        for (String s : treeMap.keySet()) {
            sb.append(s);
            int cnt = treeMap.get(s);
            if (cnt > 1) {
                sb.append(String.valueOf(cnt));
            }
        }
        return sb.toString();
    }

    private String nextAtom() {
        int start = idx++;
        while (idx < len && Character.isLowerCase(formula.charAt(idx))) {
            idx++;
        }
        return formula.substring(start, idx);
    }

    private int nextNum() {
        if (idx == len || !Character.isDigit(formula.charAt(idx))) {
            return 1;
        }
        int start = idx++;
        while (idx < len && Character.isDigit(formula.charAt(idx))) {
            idx++;
        }
        return Integer.parseInt(formula.substring(start, idx));
    }
}
