import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class p726 {
    String formula;
    int idx, len;

    public String countOfAtoms(String fml) {
        this.formula = fml; // the chemical formula
        this.idx = 0; // the index we are handling
        this.len = formula.length();
        // create the map stack
        Deque<Map<String, Integer>> stack = new ArrayDeque<>();
        // default map containing atoms outside any parentheses, eg:`Fe` in `Fe2(SO4)3`
        stack.push(new HashMap<String, Integer>());
        while (idx < len) {
            switch (formula.charAt(idx)) {
                case '(':
                    // create a new inner map to hold atoms inside the parenthese
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
                    // atom
                    // record this atom's number
                    Map<String, Integer> map = stack.peek();
                    String atom = nextAtom();
                    int n = nextNum();
                    map.put(atom, map.getOrDefault(atom, 0) + n);
            }
        }
        // turn outest map to a treeMap so that the atom name is ordered
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
        // continue matching while next character is a lowercase character
        while (idx < len && Character.isLowerCase(formula.charAt(idx))) {
            idx++;
        }
        return formula.substring(start, idx);
    }

    private int nextNum() {
        // If the following is not a number, return the default 1
        if (idx == len || !Character.isDigit(formula.charAt(idx))) {
            return 1;
        }
        int start = idx++;
        // continue matching while next character is a digit
        while (idx < len && Character.isDigit(formula.charAt(idx))) {
            idx++;
        }
        return Integer.parseInt(formula.substring(start, idx));
    }
}
