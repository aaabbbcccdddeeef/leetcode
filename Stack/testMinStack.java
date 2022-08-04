public class testMinStack {
    public static void main(String[] args) {
        MinStack ms = new MinStack();
        ms.push(2147483646);
        ms.push(2147483646);
        ms.push(2147483647);
        print(ms.top());
        // pop
        ms.pop();
        print(ms.getMin());
        // pop
        ms.pop();
        print(ms.getMin());
        //pop
        ms.pop();
        ms.push(2147483647);
        print(ms.top());
        print(ms.getMin());
        ms.push(-2147483648);
        print(ms.top());
        print(ms.getMin());
        // pop
        ms.pop();
        print(ms.getMin());
    }
    static void print(int val){
        System.out.println(val);
    }
}

// ["MinStack","push","push","push","top","pop","getMin","pop","getMin","pop","push","top","getMin","push","top","getMin","pop","getMin"]
// [[],[2147483646],[2147483646],[2147483647],[],[],[],[],[],[],[2147483647],[],[],[-2147483648],[],[],[],[]]