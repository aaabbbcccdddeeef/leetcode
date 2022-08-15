import java.util.Arrays;

public class p012 {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int totalSum = Arrays.stream(nums).sum();
        int sum = 0;
        for (int i = 0; i < n; ++i) {
            int rightSum = totalSum - nums[i] - sum;
            if (rightSum == sum)
                return i;
            sum += nums[i];
        }
        return -1;
    }
}
