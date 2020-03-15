package contest.t0315;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @description:
 * @author: bin
 * @create: 2020/3/15
 */

public class LuckyNum {
    public static void main(String[] args) {
        System.out.println(new LuckyNum().luckyNumbers(new int[][]{{1,10,4,2},{9,3,8,7},{15,16,17,12}}));
    }

    public List<Integer> luckyNumbers(int[][] matrix) {
        if (matrix.length == 0) {
            return Collections.emptyList();
        }
        List<Integer> res = new ArrayList<>(matrix.length);
        boolean[] usedRow = new boolean[matrix[0].length];
        boolean[] usedCol = new boolean[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (!usedRow[j] && !usedCol[i] && judge(matrix, i, j)) {
                    res.add(matrix[i][j]);
                    usedRow[j] = true;
                    usedCol[i] = true;
                }
            }
        }
        return res;
    }

    public boolean judge(int[][] matrix, int row, int col) {
        int cur = matrix[row][col];
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][col] > cur)
                return false;
        }
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[row][i] < cur)
                return false;
        }
        return true;
    }

}
