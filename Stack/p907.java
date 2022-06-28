import java.util.ArrayDeque;
import java.util.Deque;

public class p907 {
    int[] arr;
    int n;

    public int sumSubarrayMins(int[] arr) {
        int MOD = 1_000_000_007;

        // handle input arr
        if (arr == null || arr.length == 0) {
            return 0;
        }
        this.arr = arr;
        n = arr.length;

        long ans = 0L;
        Deque<Integer> increStack = new ArrayDeque<>();
        // add index -1 and n into the process(their value are minInfinity) so that
        // don't need to consider boundary situation.
        for (int i = -1; i <= n; i++) {
            while (!increStack.isEmpty() && getVal(i) < getVal(increStack.peek())) {
                int peek = increStack.pop();
                int left = increStack.peek();
                // add the contribution of the popped element: the left of which is the
                // increStack's peek, the right of which is the element we are handling, i.
                // CAUTION! Handle MOD carefully.
                ans = (ans + (long) (peek - left) * (i - peek) * getVal(peek)) % MOD;
            }
            increStack.push(i);
        }
        return (int) ans;
    }

    private int getVal(int idx) {
        // used for handle boundary cases
        if (idx == -1 || idx == n) {
            return Integer.MIN_VALUE;
        }
        return arr[idx];
    }
}
