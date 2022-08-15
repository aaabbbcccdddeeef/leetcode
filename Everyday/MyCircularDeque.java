public class MyCircularDeque {
    int capacity;
    int size;
    Node head, tail;

    public MyCircularDeque(int k) {
        size = 0;
        capacity = k;
        head = null;
        tail = null;
    }

    public boolean insertFront(int value) {
        if (this.isEmpty())
            return nullInsert(value);
        if (this.isFull())
            return false;
        head = new Node(value, null, head);
        head.next.last = head;
        ++size;
        return true;
    }

    public boolean insertLast(int value) {
        if (this.isEmpty())
            return nullInsert(value);
        if (this.isFull())
            return false;
        tail = new Node(value, tail, null);
        tail.last.next = tail;
        ++size;
        return true;
    }

    private boolean nullInsert(int value) {
        head = new Node(value, null, null);
        tail = head;
        size++;
        return true;
    }

    public boolean deleteFront() {
        if (this.isEmpty())
            return false;
        --size;
        head = head.next;
        if (head == null)
            tail = null;
        else
            head.last = null;
        return true;
    }

    public boolean deleteLast() {
        if (this.isEmpty())
            return false;
        --size;
        tail = tail.last;
        if (tail == null)
            head = null;
        else
            tail.next = null;
        return true;
    }

    public int getFront() {
        if (this.isEmpty())
            return -1;
        return head.val;
    }

    public int getRear() {
        if (this.isEmpty())
            return -1;
        return tail.val;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public static void main(String[] args) {
        MyCircularDeque deque = new MyCircularDeque(3);
        deque.insertLast(1);
        deque.insertLast(2);
        deque.insertFront(3);
        System.out.println(deque.getRear());
        System.out.println(deque.deleteLast());
        System.out.println(deque.deleteLast());
        System.out.println(deque.deleteLast());
        System.out.println(deque.getRear());
    }
}

class Node {
    int val;
    Node last, next;

    Node(int val, Node last, Node next) {
        this.val = val;
        this.last = last;
        this.next = next;
    }
}