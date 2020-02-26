package swordToOffer;

/**
 * @description:
 * @author: bin
 * @create: 2020/2/22
 */

public class CircleEntrance {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = head.next.next;
//        System.out.println(new CircleEntrance().findEntrance(head).val);
        System.out.println(4>>2);
    }

    public Node judgeCircle(Node head) {
        Node fast = head.next;
        Node slow = head;
        while (fast != null && fast != slow) {
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
            slow = slow.next;
        }

        return fast;
    }

    public int circleLength(Node head) {
        Node temp = judgeCircle(head);
        if (temp == null) {
            return 0;
        }
        int length = 1;
        Node n = temp.next;
        while (n != temp) {
            length++;
            n = n.next;
        }
        return length;
    }

    public Node findEntrance(Node head) {
        int length = circleLength(head);
        Node post = head, pre = head;
        while (length > 0) {
            pre = pre.next;
            length--;
        }
        while (pre != post) {
            pre = pre.next;
            post = post.next;
        }
        return pre;
    }

}

