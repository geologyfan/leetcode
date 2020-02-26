package ArrayAndString;

import java.util.HashMap;

/**
 * @description:
 * @author: bin
 * @create: 2020/2/25
 */

public class WordSearch {
    public static void main(String[] args) {
        char[][] board  = new char[][]{{'a','a'}};
        System.out.println(new WordSearch().exist(board,"aaaa"));
    }

    public boolean exist(char[][] board, String word) {
        if (board.length == 0)
            return false;

        return existHelper(board, word, new boolean[board.length][board[0].length],0);
    }

    public boolean existHelper(char[][] board, String word, boolean[][] used, int index) {
        if (index >= word.length())
            return true;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(index) && !used[i][j]) {
                    used[i][j] = true;
                    if (existHelper(board, word, used, index + 1))
                        return true;
                    used[i][j] = false;
                }
            }
        }
        return false;

    }


}
