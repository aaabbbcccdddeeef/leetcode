public class p75 {
    // actually three pointers...
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int n = nums.length;
        int zero = 0, one = n, two = n;
        while (zero < one) {
            switch (nums[zero]) {
                case 0:
                    ++zero;
                    break;
                case 1:
                    nums[zero] = nums[one - 1];
                    nums[--one] = 1;
                    break;
                case 2:
                    nums[zero] = nums[one - 1];
                    nums[--one] = 1;
                    nums[--two] = 2;
                    break;
            }
        }
    }
}
