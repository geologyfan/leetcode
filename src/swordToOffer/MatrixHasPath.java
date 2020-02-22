package swordToOffer;

import java.util.Stack;

/**
 * @description:
 * @author: bin
 * @create: 2020/2/22
 */

public class MatrixHasPath {
    public static void main(String[] args) {
        char[][] matrix = new char[][]{{'a'},{'a'},{'a'}};
        System.out.println(new MatrixHasPath().hasPath(matrix,"aaaa"));
    }

    public boolean hasPath(char[][] matrix, String str) {
        if (str.length() == 0)
            System.out.println("wrong");
        Stack<Character> stack = new Stack<>();
        for (int i = str.length() - 1; i >= 0; i--) {
            stack.push(str.charAt(i));
        }
        boolean[][] used = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < used.length; i++) {
            for (int j = 0; j < used[0].length; j++) {
                used[i][j] = false;
            }
        }
        char temp = stack.pop();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == temp) {
                    used[i][j] = true;
                    if (search(matrix, i, j, stack, used)) {
                        return true;
                    }
                    used[i][j] = false;
                }
            }
        }
        return false;
    }

    public boolean search(char[][] matrix, int i, int j, Stack<Character> stack, boolean[][] used) {
        if (stack.empty()) {
            return true;
        }
        char temp = stack.pop();
        //top
        if (j > 0 && !used[i][j - 1] && temp == matrix[i][j - 1]) {
            used[i][j - 1] = true;
            if (search(matrix, i, j - 1, stack, used))
                return true;
            used[i][j - 1] = false;
        } else if (j < matrix[0].length - 1 && !used[i][j + 1] && temp == matrix[i][j + 1]) {
            //down
            used[i][j + 1] = true;
            if (search(matrix, i, j + 1, stack, used))
                return true;
            used[i][j + 1] = false;
        } else if (i > 0 && !used[i - 1][j] && temp == matrix[i - 1][j]) {
            //left
            used[i - 1][j] = true;
            if (search(matrix, i - 1, j, stack, used))
                return true;
            used[i - 1][j] = false;
        } else if (i < matrix.length - 1 && !used[i + 1][j] && temp == matrix[i + 1][j]) {
            //right
            used[i + 1][j] = true;
            if (search(matrix, i + 1, j, stack, used))
                return true;
            used[i + 1][j] = false;
        }
        stack.push(temp);
        used[i][j] = false;
        return false;

    }

}
