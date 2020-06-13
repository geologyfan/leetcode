package newcode;

import java.util.PriorityQueue;

/**
 * @description:
 * @author: bin
 * @create: 2020/6/12
 */

public class HeBingKGePaiXu {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {

    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>((node1, node2) -> (node1.val - node2.val));
        int len = lists.length;
        ListNode headPre = new ListNode(0);
        ListNode p = headPre;
        if (len == 0) {
            return headPre.next;
        }
        for (int i = 0; i < len; i++) {
            if(lists[i]!=null){
                priorityQueue.offer(lists[i]);
            }

        }
        while (!priorityQueue.isEmpty()) {
            ListNode temp = priorityQueue.poll();
            p.next = temp;
            p = temp;
            if (temp.next != null) {
                priorityQueue.offer(temp.next);
            }
        }
        return headPre.next;
    }

}
