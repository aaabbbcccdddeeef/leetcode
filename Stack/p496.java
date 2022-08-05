import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class p496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null)
            return null;
        Map<Integer, Integer> mp = new HashMap<>();
        Deque<Integer> decreStk = new ArrayDeque<>();
        for (int x : nums2) {
            while (!decreStk.isEmpty() && decreStk.peek() < x)
                mp.put(decreStk.pop(), x);
            decreStk.push(x);
        }
        for (int i = 0; i < nums1.length; ++i) {
            nums1[i] = mp.containsKey(nums1[i]) ? mp.get(nums1[i]) : -1;
        }
        return nums1;
    }
}
