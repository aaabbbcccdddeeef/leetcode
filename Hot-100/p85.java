import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class p85 {
    public int maximalRectangle(char[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        int[][] table = new int[row][col];
        int maxSize = 0;
        for (int i = 0; i < row; i++) {
            table[i][0] = matrix[i][0] == '1' ? 1 : 0;
            for (int j = 1; j < col; j++) {
                table[i][j] = matrix[i][j] == '1' ? table[i][j - 1] + 1 : 0;
            }
        }
        for (int i = 0; i < col; i++) {
            int[] left = new int[row];
            int[] right = new int[row];
            Arrays.fill(right, row);
            Deque<Integer> mono_stack = new ArrayDeque<Integer>();
            for (int j = 0; j < row; j++) {
                while (!mono_stack.isEmpty() && table[j][i] <= table[mono_stack.peek()][i]) {
                    right[mono_stack.peek()] = j;
                    mono_stack.pop();
                }
                left[j] = mono_stack.isEmpty() ? -1 : mono_stack.peek();
                mono_stack.push(j);
            }
            for (int j = 0; j < row; j++) {
                maxSize = Math.max(maxSize, (right[j] - left[j] - 1) * table[j][i]);
            }
        }
        return maxSize;
    }
}