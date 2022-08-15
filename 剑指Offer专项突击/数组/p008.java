public class p008 {
    static public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        int start = 0, end = 0, sum = 0;
        while (end < n) {
            sum += nums[end];
            while (sum >= target) {
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start++];
            }
            ++end;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 1, 1, 1, 1, 1, 1, 1, 1 };
        minSubArrayLen(11, nums);
    }
}
