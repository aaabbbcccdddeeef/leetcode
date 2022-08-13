import java.util.ArrayDeque;
import java.util.Deque;

public class p1282op_MonoStack {
    public int maxChunksToSorted(int[] arr) {
        // every elements in stk represent a chunk
        Deque<Integer> increStk = new ArrayDeque<>();
        for (int x : arr) {
            if (increStk.isEmpty() || increStk.peek() <= x)
                increStk.push(x);
            else {
                // current x is smaller then the peek chunk
                int tmp = increStk.pop();
                // popping till find a chunk can contain x
                while (!increStk.isEmpty() && increStk.peek() > x)
                    increStk.pop();
                increStk.push(tmp);
            }
        }
        return increStk.size();
    }
}
