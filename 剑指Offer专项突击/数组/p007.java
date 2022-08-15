import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class p007 {
    static public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        if (n < 3)
            return ans;
        Arrays.sort(nums);
        for (int first = 0; first < n - 2; ++first) {
            if (nums[first] > 0)
                break;
            if (first != 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            int target = -nums[first];
            int second = first + 1, third = n - 1;
            int minSum = nums[second] + nums[second + 1];
            if (minSum > target)
                continue;
            int maxSum = nums[third] + nums[third - 1];
            if (maxSum < target)
                continue;
            while (second < third) {
                int sum = nums[second] + nums[third];
                if (sum > target)
                    --third;
                else if (sum < target)
                    ++second;
                else {
                    ans.add(Arrays.asList(new Integer[] { nums[first], nums[second++], nums[third--] }));
                    while (second < third && nums[second] == nums[second - 1])
                        ++second;
                    while (second < third && nums[third] == nums[third + 1])
                        --third;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { -1, 0, 1, 2, -1, -4 };
        System.out.println(threeSum(nums));
    }
}