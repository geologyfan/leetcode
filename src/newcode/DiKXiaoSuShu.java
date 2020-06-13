package newcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @description:
 * @author: bin
 * @create: 2020/6/11
 */

public class DiKXiaoSuShu {


    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 5};
        System.out.println(Arrays.toString(kthSmallestPrimeFraction(arr, 3)));
    }

    public static int[] kthSmallestPrimeFraction(int[] A, int K) {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>((o1, o2) -> {

            if (o1.real < o2.real) {
                return 1;
            } else if (o1.real > o2.real) {
                return -1;
            } else {
                return 0;
            }
        });
        for (int i = 0; i < A.length - 1; i++) {
            for (int j = i + 1; j < A.length; j++) {
                Node temp = new Node(A[i], A[j]);
                priorityQueue.offer(temp);
                if (priorityQueue.size() > K) {
                    priorityQueue.poll();
                }
            }
        }
        Node res = priorityQueue.poll();
        return new int[]{res.a, res.b};
    }

    static class Node {
        int a;
        int b;
        double real;

        Node(int a, int b) {
            this.a = a;
            this.b = b;
            this.real = a * 1.0 / b;
        }
    }
}
