import java.util.HashMap;
import java.util.Map;

public class p011 {
    static public int findMaxLength(int[] nums) {
        int n = nums.length;
        if (n <= 1)
            return 0;
        Map<Integer, Integer> map = new HashMap<>();
        int cnt = 0, ans = 0;
        for (int i = 0; i < n; ++i) {
            cnt += nums[i] == 0 ? -1 : 1;
            if (cnt == 0)
                ans = i+1;
            else if (map.containsKey(cnt))
                ans = Math.max(ans, i - map.get(cnt));
            map.put(cnt, Math.min(map.getOrDefault(cnt, i), i));
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 0, 1, 0, 0, 1, 1 };
        findMaxLength(nums);
    }
}
