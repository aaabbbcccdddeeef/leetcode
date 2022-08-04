import java.util.ArrayDeque;
import java.util.Deque;

class MinStack {
    private Deque<Long> diffStk;
    private long minVal;

    public MinStack() {
        diffStk = new ArrayDeque<>();
        minVal = 0;
    }

    public void push(int val) {
        if (diffStk.isEmpty()) {
            minVal = val;
            diffStk.push(0L);
        } else {
            diffStk.push(val - minVal);
            minVal = Math.min(minVal, val);
        }
    }

    public void pop() {
        if (diffStk.isEmpty())
            return;
        long diff = diffStk.pop();
        if (diff < 0) {
            minVal = minVal - diff;
        }
    }

    public int top() {
        long peek = diffStk.peek();
        return peek > 0 ? (int) (diffStk.peek() + minVal) : (int) (minVal);
    }

    public int getMin() {
        return (int) minVal;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */