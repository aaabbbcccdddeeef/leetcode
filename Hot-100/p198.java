public class p198 {
    public static void main(String[] args) {
        p198 mp198 = new p198();
        int[] nums = new int[] { 9 };
        int n = mp198.rob(nums);
        System.out.println(n);
    }

    public int rob(int[] nums) {
        int[] dp = new int[3];
        int n = nums.length;
        dp[2] = nums[0];
        for (int i = 1; i < n; i++) {
            int newDp2 = Math.max(Math.max(dp[1] + nums[i], dp[0] + nums[i]), Math.max(dp[2], dp[1]));
            dp[0] = dp[1];
            dp[1] = dp[2];
            dp[2] = newDp2;
        }
        return dp[2];
    }
}
