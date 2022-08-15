public class p009_DP {
    static public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k == 0)
            return 0;
        int n = nums.length;
        int ans = 0;
        int[] dp = new int[n];
        for (int i = 0; i < n; ++i)
            dp[i] = nums[i];
        for (int i = 0; i < n; ++i) {
            for (int j = i; j < n; ++j) {
                if (j != i)
                    dp[i] = dp[i] * nums[j];
                if (dp[i] < k)
                    ++ans;
                else
                    break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 10, 5, 2, 6 };
        numSubarrayProductLessThanK(nums, 100);
    }
}
