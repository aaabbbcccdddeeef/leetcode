public class p50 {
    public double myPow(double x, int n) {
        long N = n;
        return n >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }

    public double quickMul(double x, long N) {
        // N >= 0
        double ans = 1.0;
        // binary of N
        while (N > 0) {
            if ((N & 1) == 1)
                ans *= x;
            x *= x;
            N = N >> 1;
        }
        return ans;
    }
}
