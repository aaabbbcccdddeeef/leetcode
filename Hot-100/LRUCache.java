import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    class DLinkedNode {
        int val, key;
        DLinkedNode next, prev;

        public DLinkedNode() {
        }

        public DLinkedNode(int _val, int _key) {
            this.val = _val;
            this.key = _key;
        }
    }

    int capacity, used;
    Map<Integer, DLinkedNode> myMap = new HashMap<>();
    DLinkedNode dummyHead, dummyTail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.used = 0;
        this.dummyHead = new DLinkedNode();
        this.dummyTail = new DLinkedNode();
        this.dummyHead.next = this.dummyTail;
        this.dummyTail.prev = this.dummyHead;
    }

    public int get(int key) {
        if (myMap.containsKey(key)) {
            DLinkedNode node = myMap.get(key);
            move2Head(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (myMap.containsKey(key)) {
            DLinkedNode node = myMap.get(key);
            node.val = value;
            move2Head(node);
        } else {
            DLinkedNode newNode = new DLinkedNode(value, key);
            myMap.put(key, newNode);
            add2Head(newNode);
            used++;
            if (used > capacity) {
                DLinkedNode victim = dummyTail.prev;
                removeNode(victim);
                myMap.remove(victim.key);
                used--;
            }
        }
    }

    private void move2Head(DLinkedNode node) {
        removeNode(node);
        add2Head(node);
    }

    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void add2Head(DLinkedNode node) {
        node.prev = this.dummyHead;
        node.next = this.dummyHead.next;
        this.dummyHead.next.prev = node;
        this.dummyHead.next = node;
    }
}
