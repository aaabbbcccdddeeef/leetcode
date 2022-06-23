import java.util.Deque;
import java.util.LinkedList;

class MinStack {
    private Deque<Long> diffStack;
    private int minValue;

    public MinStack() {
        diffStack = new LinkedList<>();
        minValue = -1;
    }

    public void push(int val) {
        if (diffStack.isEmpty()) {
            diffStack.push(0L);
            minValue = val;
        } else {
            diffStack.push(Long.valueOf(val) - minValue);
            minValue = Math.min(minValue, val);
        }
    }

    public void pop() {
        Long diff = diffStack.pop();
        if (diff < 0) {
            minValue = (int) (minValue - diff);
        }
    }

    public int top() {
        Long diff = diffStack.peek();
        return diff >= 0 ? (int) (diff + minValue) : minValue;
    }

    public int getMin() {
        return diffStack.isEmpty() ? -1 : minValue;
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