import java.util.Arrays;

public class p16 {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        int n = nums.length, ans = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        for (int first = 0; first < n - 2; first++) {
            int second = first + 1, third = n - 1;
            while (second < third) {
                int minSum = nums[first] + nums[second] + nums[second + 1];
                if (minSum > target) {
                    if (Math.abs(ans - target) > Math.abs(minSum - target)) {
                        ans = minSum;
                    }
                    break;
                }
                int maxSum = nums[first] + nums[third] + nums[third - 1];
                if (maxSum < target) {
                    if (Math.abs(ans - target) > Math.abs(maxSum - target)) {
                        ans = maxSum;
                    }
                    break;
                }
                int sum = nums[first] + nums[second] + nums[third];
                if (Math.abs(ans - target) > Math.abs(sum - target)) {
                    ans = sum;
                }
                if (sum == target) {
                    return target;
                } else if (sum > target) {
                    third--;
                    while (second < third && nums[third] == nums[third + 1]) {
                        third--;
                    }
                } else {
                    second++;
                    while (second < third && nums[second] == nums[second - 1]) {
                        second++;
                    }
                }
            }
            while (first < n - 2 && nums[first] == nums[first + 1]) {
                first++;
            }
        }
        return ans;
    }
}
