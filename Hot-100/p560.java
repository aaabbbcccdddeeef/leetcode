import java.util.HashMap;

public class p560 {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> preSumMap = new HashMap<>();
        int pre = 0, count = 0;
        preSumMap.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (preSumMap.containsKey(pre - k)) {
                count += preSumMap.get(pre - k);
            }
            preSumMap.put(pre, preSumMap.getOrDefault(pre, 0) + 1);
        }
        return count;
    }
}
