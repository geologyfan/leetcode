package Array;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MaxArea {
    public static void main(String[] args) {
//        int[] height = new int[]{1, 1};
        PriorityQueue<Integer> p2 = new PriorityQueue<>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

        p2.add(1);
        priorityQueue.add(1);
        p2.add(2);
        priorityQueue.add(2);
        System.out.println(p2);
        System.out.println(priorityQueue);
//        MaxArea maxArea = new MaxArea();
//        System.out.println(Arrays.toString(maxArea.permutation("abc")));
    }

    public String[] permutation(String s) {

        int length = s.length();
        if (length < 1) {
            return new String[0];
        }


        String[] cur = new String[]{s.substring(0, 1)};

        for (int i = 1; i < length; i++) {
            int lastLen = cur.length;
            int lastStrLen = cur[0].length();
            String[] nextArr = new String[lastLen * (lastStrLen + 1)];

            for (int j = 0; j < cur.length; j++) {
                String str = cur[j];
                for (int k = 0; k <= lastStrLen; k++) {
                    int tempIndex = j * (lastStrLen + 1) + k;
                    nextArr[tempIndex] = str.substring(0, k) + s.charAt(i) + str.substring(k);
                }
            }
            cur = nextArr;
        }

        return cur;

    }

    public int maxArea(int[] height) {
        int maxarea = 0;
        int left = 0;
        int right = height.length - 1;

        for (int i = 0; i < height.length && height[i] >= height[left]; i++) {

            for (int j = height.length - 1; j > i && height[j] >= height[right]; j--) {

                int temp = (j - i) * getMin(height[i], height[j]);
                if (temp > maxarea) {
                    maxarea = temp;
                    left = i;
                    right = j;
                }

            }

        }
        return maxarea;
    }

    public int getMin(int x, int y) {
        return x > y ? y : x;
    }

//    public int maxArea_2(int[] height) {
//        int maxarea = 0;
//        int left = 0;
//        int right = height.length;
//        while (left < right) {
//            maxarea = Math.max(maxarea, (right - left) * Math.min(height[left], height[right]));
//            if (height[left] < height[right])
//                left++;
//            else
//                right--;
//        }
//    }

    Pattern pattern = Pattern.compile("");


    public int maximalSquare(char[][] matrix) {
        int xLen = matrix.length;
        if (xLen == 0) {
            return 0;
        }
        int yLen = matrix[0].length;
        int maxLen = 0;

        for (int x = 0; x < xLen; x++) {
            for (int y = 0; y < yLen; y++) {
                if (matrix[x][y] == '1') {
                    int len = 0;
                    while (addOne(matrix, x, y, len)) {
                        len++;
                        maxLen = Math.max(maxLen, len);
                    }
                }
            }
        }

        return maxLen * maxLen;

    }

    public boolean addOne(char[][] matrix, int startX, int startY, int len) {
        if ((startX + len) >= matrix.length || (startY + len) >= matrix[0].length) {
            return false;
        }
        for (int x = startX; x <= startX + len; x++) {
            if (matrix[x][startY + len] == '0') {
                return false;
            }
        }
        for (int y = startY; y <= startY + len; y++) {
            if (matrix[startX + len][y] == '0') {
                return false;
            }
        }
        return true;
    }
}
