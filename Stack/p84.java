import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class p84 {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> increStack = new LinkedList<>();
        int n = heights.length;
        int rightLim[] = new int[n];
        int leftLim[] = new int[n];
        Arrays.fill(rightLim, n);
        for (int i = 0; i < n; i++) {
            while (!increStack.isEmpty() && heights[i] < heights[increStack.peek()]) {
                rightLim[increStack.pop()] = i;
            }
            leftLim[i] = increStack.isEmpty() ? -1 : increStack.peek();
            increStack.push(i);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, (rightLim[i] - leftLim[i] - 1) * heights[i]);
        }
        return ans;
    }
}
