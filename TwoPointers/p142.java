public class p142 {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                fast = head;
                while (true) {
                    if (fast == slow) {
                        return fast;
                    }
                    fast = fast.next;
                    slow = slow.next;
                }
            }
        }
        return null;
    }
}
