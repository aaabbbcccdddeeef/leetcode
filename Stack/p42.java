import java.util.Deque;
import java.util.LinkedList;

public class p42 {
    public int trap(int[] height) {
        // a mono decrease stack
        Deque<Integer> monoStack = new LinkedList<>();
        int n = height.length, ans = 0;
        for (int i = 0; i < n; i++) {
            while (!monoStack.isEmpty() && height[i] > height[monoStack.peek()]) {
                int top = height[monoStack.pop()];
                if (monoStack.isEmpty()) {
                    break;
                }
                ans += (Math.min(height[i], height[monoStack.peek()]) - top) * (i - monoStack.peek() - 1);
            }
            monoStack.push(i);
        }
        return ans;
    }
}
