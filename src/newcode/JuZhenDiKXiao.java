package newcode;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @description:
 * @author: bin
 * @create: 2020/6/11
 */

public class JuZhenDiKXiao {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}
        };
        System.out.println(kthSmallest2(matrix,8));
    }

    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                priorityQueue.offer(matrix[i][j]);
                if (priorityQueue.size() > k) {
                    priorityQueue.poll();
                }
            }
        }
        return priorityQueue.poll();
    }

    public static int kthSmallest2(int[][] matrix, int k) {
        int xLen = matrix.length;
        if(xLen==0){
            return -1;
        }
        int yLen = matrix[0].length;
        int left = matrix[0][0];
        int right = matrix[xLen-1][yLen-1];

        while(left<right){
            int mid = (left+right)>>>1;
            int count = 0;
            int x = xLen-1;
            int y = 0;
            while(x>=0&&y<yLen){
                if(matrix[x][y]<=mid){
                    count+=x+1;
                    y++;
                }else{
                    x--;
                }
            }
            if(count<k){
                left  = mid+1;
            }else{
                right = mid;
            }
        }
        return left;
    }

}
