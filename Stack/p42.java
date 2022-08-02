import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class p42 {
    static public int trap(int[] height) {
        if (height == null) {
            return 0;
        }
        int n = height.length, ans = 0;
        Deque<Integer> decStk = new ArrayDeque<>();
        for (int i = 0; i < n; ++i) {
            // keep pop&calculating till empty or meet larger in-stack elements
            while (!decStk.isEmpty() && height[i] > height[decStk.peek()]) {
                // the bar we want to calculate water above it
                int curr = decStk.pop();
                if (decStk.isEmpty()) {
                    break;
                }
                // the left one bar work with bar-`i` to hold water
                int left = decStk.peek();
                int currWidth = i - left - 1;
                int currHeight = Math.min(height[left], height[i]) - height[curr];
                ans += currHeight * currWidth;
            }
            decStk.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] h1 = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        System.out.println(trap(h1));
        int[] h2 = { 4, 2, 0, 3, 2, 5 };
        System.out.println(trap(h2));
    }
}
