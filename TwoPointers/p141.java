public class p141 {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            head = head.next;
            if (fast == head) {
                return true;
            }
        }
        return false;
    }
}
