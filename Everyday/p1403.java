import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class p1403 {
    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int totalSum = IntStream.of(nums).sum();
        List<Integer> lst = new ArrayList<>();
        int sum = 0;
        for (int i = n - 1; i >= 0; --i) {
            if (sum > totalSum / 2)
                break;
            sum += nums[i];
            lst.add(nums[i]);
        }
        return lst;
    }
}
