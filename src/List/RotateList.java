package List;

public class RotateList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
        head = new RemoveNthNodeFromEndOfList().removeNthFromEnd(head, 4);
    }

    public ListNode rotateRight(ListNode head, int k) {
        ListNode h = head;
        int length = 0;
        while (h != null) {
            length++;
            h = h.next;
        }
        if (length==0 || (k%length) < 1) return head;
        k=k%length;
        ListNode rear = head;
        while (k > 0 && rear != null) {
            k--;
            rear = rear.next;
        }
        if (k > 0 || rear == null) {
            return head;
        }
        ListNode pre = new ListNode(0);
        pre.next = head;
        while (rear.next != null) {
            rear = rear.next;
            pre = pre.next;
        }
        pre = pre.next;
        ListNode tempHead = pre.next;
        rear.next = head;
        pre.next = null;
        return tempHead;

    }
}
