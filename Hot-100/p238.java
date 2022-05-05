public class p238 {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        ans[0] = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i - 1] == 0) {
                break;
            }
            ans[i] = ans[i - 1] * nums[i - 1];
        }
        int product = 1;
        for (int i = n - 2; i >= 0; i--) {
            product *= nums[i + 1];
            ans[i] *= product;
        }
        return ans;
    }
}