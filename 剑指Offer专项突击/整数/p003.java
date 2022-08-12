public class p003 {
    public int[] countBits(int n) {
        int[] dpAns = new int[n + 1];
        for (int i = 1; i < n + 1; ++i) {
            dpAns[i] = dpAns[i >> 1] + (i & 1);
        }
        return dpAns;
    }
}
