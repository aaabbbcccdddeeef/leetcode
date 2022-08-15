public class p009_SlidingWIndow {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        int prod = 1, i = 0, j = 0;
        for (j = 0; j < n; ++j) {
            // calculate number of subarrays end with nums[j]
            prod *= nums[j];
            while (i <= j && prod >= k)
                prod /= nums[i++];
            ans += j - i + 1;
        }
        return ans;
    }
}
