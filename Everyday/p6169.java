public class p6169 {
    static public int longestNiceSubarray(int[] nums) {
        int left = 0, right = 0, mask = 0;
        int n = nums.length;
        int res = 0;
        while (right < n) {
            while ((mask & nums[right]) > 0)
                mask ^= nums[left++];
            mask ^= nums[right++];
            res = Math.max(res, right - left + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = { 615598711, 264, 65552, 50331652 };
        System.out.println(longestNiceSubarray(nums));
    }
}