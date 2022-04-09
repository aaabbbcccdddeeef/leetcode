import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class p84 {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length, maxSize = 0;
        Deque<Integer> mono_stack = new ArrayDeque<Integer>();
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(right, n);
        for (int i = 0; i < n; i++) {
            while (!mono_stack.isEmpty() && heights[mono_stack.peek()] > heights[i]) {
                right[mono_stack.peek()] = i;
                mono_stack.pop();
            }
            left[i] = mono_stack.isEmpty() ? -1 : mono_stack.peek();
            mono_stack.push(i);
        }
        for (int i = 0; i < n; i++) {
            maxSize = Math.max(maxSize, (right[i] - left[i] - 1) * heights[i]);
        }
        return maxSize;
    }
}