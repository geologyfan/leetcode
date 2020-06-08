package vivoExam;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @description:
 * @author: bin
 * @create: 2020/6/7
 */

public class P3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        ListNode[] arr = new ListNode[n];
        for (int i = 0; i < n; i++) {
            ListNode nodePre = new ListNode(0);
            ListNode p = nodePre;
            String line = sc.nextLine();
            if(line.equals("")){
                continue;
            }
            String[] nodes = line.split(" ");
            for (String node : nodes) {
                p.next = new ListNode(Integer.parseInt(node));
                p = p.next;
            }
            arr[i] = nodePre.next;
        }
        ListNode res = mergeK(arr);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }

    }

    static class ListNode {
        int val;

        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    private static ListNode mergeK(ListNode[] arr) {
        int dis = 1;
        int len = arr.length;
        while (dis <= len ) {
            for (int i = 0; i + dis < len; i += 2 * dis) {
                arr[i] = mergeTwo(arr[i], arr[i + dis]);
            }
            dis *= 2;
        }
        return arr[0];
    }


    private static ListNode mergeTwo(ListNode list1, ListNode list2) {
        ListNode headPre = new ListNode(0);
        ListNode p = headPre;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                p.next = list1;
                p = list1;
                list1 = list1.next;
            } else {
                p.next = list2;
                p = list2;
                list2 = list2.next;
            }
        }
        while (list1 != null) {
            p.next = list1;
            p = list1;
            list1 = list1.next;
        }
        while (list2 != null) {
            p.next = list2;
            p = list2;
            list2 = list2.next;
        }
        return headPre.next;
    }
}
