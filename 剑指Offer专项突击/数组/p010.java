import java.util.HashMap;
import java.util.Map;

public class p010 {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int preSum = 0;
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < n; ++i) {
            preSum += nums[i];
            // check if any satifable prefix exist in map.
            if (map.containsKey(preSum - k))
                ans += map.get(preSum - k);
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }
        return ans;
    }
}
