package newcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @description:
 * @author: bin
 * @create: 2020/6/10
 */

public class RenWuDiaoDu {
    public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
//        int M = sc.nextInt();
//        int P = sc.nextInt();
//        int[][] ideas = new int[P][5];
//        int originTime = Integer.MAX_VALUE;
//        for (int i = 0; i < P; i++) {
//            for (int j = 0; j < 4; j++) {
//                ideas[i][j] = sc.nextInt();
//            }
//            ideas[i][4] = i;
//            originTime = Math.min(originTime, ideas[i][1]);
//        }
//        func(ideas, N, M, P,originTime);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(1);
        pq.add(2);
        System.out.println(pq.poll());

    }

    private static void func(int[][] ideas, int N, int M, int P,int originTime) {


        Arrays.sort(ideas, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[2] > o2[2]) {
                    return 1;
                } else if (o1[2] < o2[2]) {
                    return 0;
                } else if (o1[3] < o2[3]) {
                    return 0;
                } else if (o1[3] > o2[3]) {
                    return 0;
                } else if (o1[1] < o2[1]) {
                    return 0;
                } else if (o1[1] > o2[1]) {
                    return 0;
                } else {
                    return o2[0] - o1[0];
                }
            }
        });
        int nextTime = originTime;
        int task = 0;
        int[] doneTimeOfTask = new int[P];
        int[] workTimeOfCoder = new int[M];
        while (task < P) {
            int curTime = nextTime;
            nextTime = Integer.MAX_VALUE;
            for (int i = 0; i < M; i++) {

                if (workTimeOfCoder[i] <= curTime) {
                    int taskTime = ideas[task][3];
                    workTimeOfCoder[i] += taskTime;
                    doneTimeOfTask[ideas[task][4]] = curTime + taskTime;
                    P--;
                    nextTime = Math.min(nextTime, workTimeOfCoder[i]);
                }
            }
        }
    }


}
