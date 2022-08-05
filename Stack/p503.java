import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class p503 {
    static public int[] nextGreaterElements(int[] nums) {
        Deque<Integer> decreStk = new ArrayDeque<>();
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        for (int i = 0; i < 2 * n; ++i) {
            while (!decreStk.isEmpty() && nums[decreStk.peek()] < nums[i % n]) {
                int k = decreStk.pop();
                if (ans[k] == -1)
                    ans[k] = nums[i % n];
            }
            decreStk.push(i % n);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 100, 1, 11, 1 };
        nextGreaterElements(nums);
    }
}
