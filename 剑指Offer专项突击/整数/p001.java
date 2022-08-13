public class p001 {
    // calculate m/n
    public int divide(int m, int n) {
        // Special cases
        if (m == Integer.MIN_VALUE) {
            if (n == 1)
                return m;
            else if (n == -1)
                return Integer.MAX_VALUE;
        }
        if (n == Integer.MIN_VALUE)
            return m == n ? 1 : 0;
        if (m == 0)
            return 0;

        // in order to handle problem more easily, turn m and n into same sign
        // turn m, n to negative, incase -2^32 turn to postive and overflow
        int sign = 1;
        if (m > 0) {
            sign = -sign;
            m = -m;
        }
        if (n > 0) {
            sign = -sign;
            n = -n;
        }

        // binary search
        int left = 1, right = Integer.MAX_VALUE, ans = 0;
        while (left <= right) {
            // calculate mid without divide /
            int mid = left + ((right - left) >> 1);
            if (quickAdd(m, n, mid)) {
                // if mid is satisfiable, try to find bigger q
                ans = mid;
                // if reach the max
                if (ans == Integer.MAX_VALUE)
                    break;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return sign > 0 ? ans : -ans;
    }

    public boolean quickAdd(int m, int n, int q) {
        // m, n are negative, q is postive
        // return if q*n >= m
        int result = 0, add = n;
        while (q != 0) {
            // if this bit is 1
            if ((q & 1) == 1) {
                // incase `result+add` out of negative boundary,
                // judge if `result+add<m`, aka `result<m-add`
                if (result < m - add)
                    return false;
                result += add;
            }
            if (q > 1) {
                // if q>1 means `result` at least will add `2*add`
                // we need to judge if `2*add`(neg)<m(neg)
                // if so, no need to add more, `q*n` must < `m`. Return false
                if (add < m - add) {
                    // use `add<m-add` instead of `add+add<m`:
                    // incase `add+add` out boundary
                    return false;
                }
            }
            add += add;
            q = q >> 1;
        }
        return true;
    }
}