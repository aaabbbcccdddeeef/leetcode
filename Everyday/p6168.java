class p6168 {
    private static final int mod = (int) 1e9 + 7;

    private static long[][] dp = new long[1001][1001];
    static {
        for (int i = 0; i <= 1000; ++i)
            dp[i][0] = 1;
        for (int i = 1; i <= 1000; ++i) {
            for (int j = 1; j <= i; ++j)
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % mod;
        }
    }

    public int numberOfWays(int startPos, int endPos, int k) {
        int diff = Math.abs(endPos - startPos);
        if ((diff + k) % 2 != 0 || diff > k)
            return 0;
        return (int) (dp[k][(diff + k)] % mod);
    }
}