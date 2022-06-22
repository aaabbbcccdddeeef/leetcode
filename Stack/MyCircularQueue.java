class MyCircularQueue {
    private Integer m_queue[];
    private int m_capacity, m_size;
    private int m_readPos, m_writePos;

    public MyCircularQueue(int k) {
        m_queue = new Integer[k];
        m_capacity=k;
        m_readPos=0;
        m_writePos=0;
    }

    public boolean enQueue(int value) {
        if (m_size == m_capacity) {
            return false;
        }
        m_queue[m_writePos++] = value;
        m_size++;
        m_writePos %= m_capacity;
        return true;
    }

    public boolean deQueue() {
        if (m_size == 0) {
            return false;
        }
        m_readPos++;
        m_size--;
        m_readPos %= m_capacity;
        return true;
    }

    public int Front() {
        if (m_size == 0) {
            return -1;
        }
        return m_queue[m_readPos];
    }

    public int Rear() {
        if (m_size == 0) {
            return -1;
        }
        return m_queue[m_writePos == 0 ? m_capacity - 1 : m_writePos - 1];
    }

    public boolean isEmpty() {
        return m_size == 0;
    }

    public boolean isFull() {
        return m_size == m_capacity;
    }
}
