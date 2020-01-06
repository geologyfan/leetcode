package HashTable;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.Hashtable;

public class ValidSudo {
    public static void main(String[] args) {
//        new ValidSudo().isValidSudoku();
        System.out.println('9'-'0');
    }

    public boolean isValidSudoku(char[][] board) {
        int[] hashtable = {1, 1, 1, 1, 1, 1, 1, 1, 1};
        for (int i = 0; i < 9; i++) {
            if (!isValid(hashtable, board, i, i, 0, 8))
                return false;
            if (!isValid(hashtable, board, 0, 8, i, i))
                return false;
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!isValid(hashtable, board, i * 3, i * 3 + 2, j * 3, j * 3 + 2))
                    return false;
            }
        }
        return true;
    }

    public boolean isValid(int[] hashtable, char[][] board, int highStart, int highEnd, int widthStart, int widthEnd) {
        for (int i = 0; i <= 8; i++)
            hashtable[i] = 1;
        char temp;
        for (int i = highStart; i <= highEnd; i++) {
            for (int j = widthStart; j <= widthEnd; j++) {
                temp = board[i][j];
                if (temp != '.') {
                    int tmp = temp-'0';
                    if (hashtable[tmp - 1] > 0)
                        hashtable[tmp - 1] = 0;
                    else
                        return false;
                }
            }

        }
        return true;
    }


}
