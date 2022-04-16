public class p152 {
    public int maxProduct(int[] nums) {
        int numsLen = nums.length, max = nums[0], min = nums[0], res = nums[0];
        for (int i = 1; i < numsLen; i++) {
            int maxn = max, minn = min;
            max = Math.max(maxn * nums[i], Math.max(minn * nums[i], nums[i]));
            min = Math.min(minn * nums[i], Math.min(maxn * nums[i], nums[i]));
            res = Math.max(res, max);
        }
        return res;
    }
}
