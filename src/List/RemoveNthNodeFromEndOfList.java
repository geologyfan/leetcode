package List;

public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head = new RemoveNthNodeFromEndOfList().removeNthFromEnd(head, 2);

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (0 == n) return head;
        ListNode pre = head;
        while (n > 0 && pre != null) {
            n--;
            pre = pre.next;
        }
        if (n > 0) return null;
        if (pre == null) {
            return head.next;
        } else {
            ListNode temp = new ListNode(0);
            temp.next = head;
            while (pre != null) {
                pre = pre.next;
                temp = temp.next;
            }
            temp.next = temp.next.next;
            return head;
        }
    }
}
