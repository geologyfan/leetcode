package List;

public class ReverseNodesInKGroup {
    public static void main(String[] args) {

    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode headPre = new ListNode(0);
        headPre.next = head;
        ListNode temp = headPre;
        while (temp != null) {
            temp = reverseK(temp, k);
        }
        return headPre.next;

    }


    public ListNode reverseK(ListNode headPre, int k) {
        ListNode first = headPre.next;
        ListNode kth = headPre;

        int tempK = k;
        while (tempK > 0 && kth != null) {
            kth = kth.next;
            tempK--;
        }
        if (tempK > 0|| kth==null) return null;

        ListNode temp = first.next;
        ListNode temp2;
        first.next = kth.next;
        while (k - 1 > 0) {
            k--;
            temp2 = temp.next;
            temp.next = headPre.next;
            headPre.next = temp;
            temp = temp2;
        }
        return first;
    }
}
