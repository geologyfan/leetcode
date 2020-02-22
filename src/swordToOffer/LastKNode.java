package swordToOffer;

import sun.rmi.runtime.Log;

/**
 * @description:
 * @author: bin
 * @create: 2020/2/22
 */

public class LastKNode {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        System.out.println(new LastKNode().find(head, 5).val);
    }

    public Node find(Node head, int k) {
        Node post = head;
        while (k != 0 && head != null) {
            head = head.next;
            k--;
        }
        if (k != 0) {
            return null;
        }
        while (head != null) {
            head = head.next;
            post = post.next;
        }
        return post;
    }
}
