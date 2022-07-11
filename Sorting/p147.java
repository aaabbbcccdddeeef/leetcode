public class p147 {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(0, head);
        ListNode sorted = head, curr = head.next;
        while (curr != null) {
            // if larger than last elements of sorted, put it last
            if (sorted.val <= curr.val) {
                sorted = sorted.next;
            } else {
                ListNode tmp = dummyHead;
                // find where is next larger elements
                while (tmp.next.val <= curr.val) {
                    tmp = tmp.next;
                }
                sorted.next = curr.next;
                curr.next = tmp.next;
                tmp.next = curr;
            }
            curr = sorted.next;
        }
        return dummyHead.next;
    }
}