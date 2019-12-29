package List;


public class palindromeLinkList {
    public static void main(String[] args) {


    }
    public boolean isPalindrome(ListNode head) {
        ListNode reverse = reverseList(head);
        while (head!=null){
            if(head.val!=reverse.val)
                return false;
            head = head.next;
            reverse = reverse.next;
        }
        return true;
    }

    public ListNode reverseList(ListNode head){
        ListNode reverse =new ListNode(0);
        reverse.next = null;
        while (head!=null){
            ListNode  temp = new ListNode(head.val);
            temp.next = reverse.next;
            reverse.next = temp;
            head = head.next;
        }
        return reverse.next;
    }


}
