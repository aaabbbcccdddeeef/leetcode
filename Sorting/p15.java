import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class p15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 3)
            return ans;
        Arrays.sort(nums);
        int n = nums.length;
        for (int first = 0; first < n - 2; ++first) {
            if (nums[first] > 0)
                break;
            if (first > 0 && nums[first] == nums[first - 1])
                continue;
            int second = first + 1, third = n - 1;
            int target = -nums[first];
            while (second < third) {
                int sum = nums[second] + nums[third];
                if (sum == target){
                    ans.add(new ArrayList<>(Arrays.asList(nums[first], nums[second++], nums[third--])));
                    while(second<third&&nums[second]==nums[second-1])
                        ++second;
                    while(second<third&&nums[third]==nums[third+1])
                        --third;
                }
                else if (sum > target)
                    --third;
                else
                    ++second;
            }
        }
        return ans;
    }
}
