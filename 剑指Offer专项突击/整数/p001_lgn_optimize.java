import java.util.ArrayList;
import java.util.List;

public class p001_lgn_optimize {
    // p001.java complexity is O(lgn^2) cause every time we need to calculate n*q,
    // which is lgn. We can store the result then decrese the whole complexity to
    // O(lgn)
    public int divide(int m, int n) {
        // special cases
        if (m == Integer.MIN_VALUE) {
            if (n == 1)
                return Integer.MIN_VALUE;
            if (n == -1)
                return Integer.MAX_VALUE;
        }
        if (n == Integer.MIN_VALUE)
            return m == n ? 1 : 0;
        if (m == 0)
            return 0;

        // turn signs to negative
        boolean sign = true;
        if (m > 0) {
            sign = !sign;
            m = -m;
        }
        if (n > 0) {
            sign = !sign;
            n = -n;
        }

        // generate candidates values
        List<Integer> candidates = new ArrayList<>();
        candidates.add(n);
        int index = 0;
        while (candidates.get(index) >= m - candidates.get(index)) {
            candidates.add(candidates.get(index) + candidates.get(index));
            ++index;
        }

        // binary minus
        int ans = 0;
        for (int i = candidates.size() - 1; i >= 0; --i) {
            if (candidates.get(i) >= m) {
                ans += 1 << i;
                m -= candidates.get(i);
            }
        }
        return sign ? ans : -ans;
    }
}
