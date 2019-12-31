package List;

public class SwapNodesInPairs {
    public static void main(String[] args) {

    }

    public ListNode swapPairs(ListNode head){
        ListNode headPre = new ListNode(0);
        headPre.next=head;
        ListNode temp = headPre;
        while(temp.next!=null&&temp.next.next!=null){
            temp = swap(temp);
        }
        return headPre.next;
    }

    public ListNode swap(ListNode head){
        ListNode first = head.next;
        ListNode second = first.next;
        first.next = second.next;
        second.next = first;
        head.next = second;
        return first;
    }
}
