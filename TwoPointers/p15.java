import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class p15 {
    // tag: Two Pointers
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return ans;
        }
        int n = nums.length;
        // sort the array to remove duplicate combinations later
        Arrays.sort(nums);
        for (int first = 0; first < n - 2; first++) {
            // if the first element is positive, then impossible to form three sum to 0
            if (nums[first] > 0) {
                break;
            }
            // if same as last round, skip to remove duplicate combinations
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // start from right after first and end of array
            int second = first + 1, third = n - 1, target = -nums[first];
            while (second < third) {
                int laterSum = nums[second] + nums[third];
                if (laterSum == target) {
                    ans.add(new ArrayList<>(Arrays.asList(nums[first], nums[second++], nums[third--])));
                    // find next different 'second' element, in order to remove duplicate
                    // combinations
                    while (second < third && nums[second] == nums[second - 1]) {
                        second++;
                    }
                    // find next different 'third' element, in order to remove duplicate
                    // combinations
                    while (second < third && nums[third] == nums[third + 1]) {
                        third--;
                    }
                } else if (laterSum > target) {
                    // need to decrease sum
                    third--;
                } else {
                    // need to increase sum
                    second++;
                }
            }
        }
        return ans;
    }
}