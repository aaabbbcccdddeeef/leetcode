public class p86 {
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        ListNode dummySmall = new ListNode();
        ListNode dummyBig = new ListNode();
        ListNode small = dummySmall, big = dummyBig;
        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                big.next = head;
                big = big.next;
            }
            head = head.next;
        }
        small.next = dummyBig.next;
        big.next = null;
        return dummySmall.next;
    }
}
