package List;

public class MergeKSortedLists {
    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(4);
        head1.next.next = new ListNode(5);
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(3);
        head2.next.next = new ListNode(4);
        ListNode head3 = new ListNode(2);
        head3.next = new ListNode(6);
//        head3.next.next = new ListNode(3);
        ListNode[] lists = {head1, head2, head3};
        ListNode head = new MergeKSortedLists().mergeKLists2(lists);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }

    }

    public ListNode mergeKLists(ListNode[] lists) { //slow
        ListNode headPre = new ListNode(0);
        headPre.next = null;
        ListNode temp = headPre;
        int length = lists.length;
        boolean flag = true;
        while (flag) {
            flag = false;
            int min = Integer.MAX_VALUE;
            int tempMinIndex = 0;
            for (int i = 0; i < length; i++) {
                if (lists[i] != null) {
                    flag = true;
                    if (lists[i].val <= min) {
                        min = lists[i].val;
                        tempMinIndex = i;
                    }
                }
            }
            if (flag) {
                temp.next = lists[tempMinIndex];
                temp = temp.next;
                lists[tempMinIndex] = lists[tempMinIndex].next;
            }
        }
        return headPre.next;
    }

    public ListNode mergeKLists2(ListNode[] lists) { //little faster
        MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();
        int len = lists.length;
        if (len == 0) return null;
        ListNode head = lists[0];
        for (int i = 1; i < len; i++) {
            head = mergeTwoSortedLists.mergeTwoLists(head, lists[i]);
        }
        return head;
    }

    public ListNode mergeKLists3(ListNode[] lists) {  //fastest
        MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();
        int len = lists.length;
        if(len==0) return null;
        int interval = 1;
        while (interval < len) {
            for (int i = 0; i < len; i += 2 * interval) {
                if (i + interval < len) {
                    lists[i] = mergeTwoSortedLists.mergeTwoLists(lists[i], lists[i + interval]);
                }
            }
            interval *= 2;
        }
        return lists[0];

    }
}
