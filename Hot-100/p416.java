/**
 * p416
 */
public class p416 {
    public static void main(String[] args) {
        int[] nums = new int[] { 1, 5, 11, 5 };
        canPartition(nums);
    }

    public static boolean canPartition(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return false;
        }
        int totalSum = 0, half = 0, maxNum = 0;
        for (int num : nums) {
            totalSum += num;
            maxNum = Math.max(maxNum, num);
        }
        if (totalSum % 2 != 0 || totalSum / 2 < maxNum) {
            return false;
        }
        half = totalSum / 2;
        boolean[] dp = new boolean[half + 1];
        dp[0] = true;
        for (int i = 0; i < len; i++) {
            int num = nums[i];
            for (int j = half; j >= num; j--) {
                dp[j] = dp[j] | dp[j - num];
            }
        }
        return dp[half];
    }
}